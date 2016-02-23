package org.arquillian.cube.openshift.impl.client;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.openshift.api.model.RouteFluent;
import io.fabric8.openshift.client.OpenShiftClient;

import java.io.File;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteBuilder;
import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;

public class GitServer {

    private OpenShiftClient client;
    private String namespace;
	private String routeSuffix;
    private Pod server;
	private Service service;
	private Route route;

    public GitServer(OpenShiftClient client, String namespace, String routeSuffix) {
        this.client = client;
        this.namespace = namespace;
		this.routeSuffix = routeSuffix;
    }

    public URI push(File source, String name) throws Exception {
        init();

        URI server = getServerURI();

        String id = name;
        String repoUrl = server.toASCIIString() + "/" + id;

        File gitRoot = new File("target", id);
        FileUtils.copyDirectory(source, gitRoot);

        Git git = Git.init().setDirectory(gitRoot).call();
        Repository repo = git.getRepository();
        repo.getConfig().setString("remote", "origin", "url", repoUrl);
        repo.getConfig().save();

        git.add().addFilepattern(".").call();
        git.commit().setMessage("testing").setAuthor("Arquillian", "cube@discuss.arquillian.org").call();
        git.push().setRemote("origin").setPushAll().setForce(true).call();
        repo.close();

        return URI.create(repoUrl);

    }

    public void shutdown() throws Exception {
        if (server != null) {
            client.pods().inNamespace(namespace).withName(server.getMetadata().getName()).delete();
            client.secrets().inNamespace(namespace).withName("gitserver-config").delete();
			client.routes().inNamespace(namespace).withName("arquillian-gitserver").delete();
			client.services().inNamespace(namespace).withName("arquillian-gitserver").delete();
        }
    }

    private void init() throws Exception {
        if (server == null) {
            server = getPodSpec();
			service = getServiceSpec();
			route = getRouteSpec();

			service = client.services().inNamespace(namespace).withName(service.getMetadata().getName()).get();
			if (service == null) {
				service = client.services().inNamespace(namespace).create(getServiceSpec());
			}

			route = client.routes().inNamespace(namespace).withName(route.getMetadata().getName()).get();
			if (route == null) {
				route = client.routes().inNamespace(namespace).create(getRouteSpec());
			}

            server = client.pods().inNamespace(namespace).withName(server.getMetadata().getName()).get();
            if (server == null) {
                server = client.pods().inNamespace(namespace).create(getPodSpec());
            }
            server = ResourceUtil.waitForStart(client, server);
        }
    }

    private URI getServerURI() {
        return URI.create("http://" + route.getSpec().getHost());
    }

	private Pod getPodSpec() {
		Map<String, String> labels = new HashMap<String, String>();
		labels.put("generatedby", "arquillian");
		labels.put("name", "arquillian-gitserver");

		return new PodBuilder()
				.withNewMetadata()
				.withName("arquillian-gitserver")
				.withLabels(labels)
				.endMetadata()
			.withNewSpec()
				.addNewContainer()
					.withName("arquillian-gitserver")
					.withImage("maschmid/openshift-arquillian-gitserver")
					.withImagePullPolicy("Always")
					.addNewPort()
						.withContainerPort(8080)
						.endPort()
					.addNewEnv()
						.withName("GIT_HOME")
						.withValue("/var/lib/git")
						.endEnv()
				.endContainer()
				.endSpec()
			.build();
	}

	private Service getServiceSpec() {

		Map<String, String> labels = new HashMap<String, String>();
		labels.put("generatedby", "arquillian");
		labels.put("name", "arquillian-gitserver");

		return new ServiceBuilder()
				.withNewMetadata()
					.withName("arquillian-gitserver")
					.withLabels(labels)
				.endMetadata()
				.withNewSpec()
					.addNewPort().withPort(8080).endPort()
					.addToSelector(labels)
				.endSpec().build();
	}

	private Route getRouteSpec() {
		Map<String, String> labels = new HashMap<String, String>();
		labels.put("generatedby", "arquillian");

		RouteFluent.SpecNested<RouteBuilder> routeBuilderSpecNested = new RouteBuilder()
				.withNewMetadata()
				.withName("arquillian-gitserver")
				.withLabels(labels)
				.endMetadata()
				.withNewSpec();

		if (routeSuffix != null) {
			routeBuilderSpecNested = routeBuilderSpecNested.withHost("arquillian-gitserver" + routeSuffix);
		}

		return routeBuilderSpecNested.withNewTo().withKind("Service").withName("arquillian-gitserver").endTo()
				.endSpec().build();
	}
}
