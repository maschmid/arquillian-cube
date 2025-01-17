package org.arquillian.cube.docker.impl.client.config;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

public class CubeContainer {

    private String workingDir;
    private Boolean disableNetwork;
    private String hostName;
    private Collection<String> portSpecs;
    private String user;
    private Boolean tty;
    private Boolean stdinOpen;
    private Boolean stdinOnce;
    private Integer memoryLimit;
    private Integer memorySwap;
    private Integer cpuShares;
    private String cpuSet;
    private Boolean attachStdin;
    private Boolean attachSterr;
    private Collection<String> env;
    private Collection<String> cmd;
    private Collection<String> dns;
    private Collection<String> volumes;
    private Collection<String> volumesFrom;
    private Collection<String> binds;
    private Collection<Link> links;
    private Collection<PortBinding> portBindings;
    private Collection<ExposedPort> exposedPorts;
    private Boolean privileged;
    private Boolean publishAllPorts;
    private String networkMode;
    private Collection<String> dnsSearch;
    private Collection<Device> devices;
    private RestartPolicy restartPolicy;
    private Collection<String> capAdd;
    private Collection<String> capDrop;
    private Collection<String> extraHosts;
    private Collection<String> entryPoint;
    private String domainName;
    private Boolean alwaysPull = false;
    private Await await;

    private Image image;
    private String extendsImage;

    private boolean ReadonlyRootfs;
    private Map<String, String> labels;

    private BuildImage buildImage;

    private Collection<BeforeStop> beforeStop;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public BuildImage getBuildImage() {
        return buildImage;
    }

    public void setBuildImage(BuildImage buildImage) {
        this.buildImage = buildImage;
    }

    public Collection<PortBinding> getPortBindings() {
        return portBindings;
    }

    public void setPortBindings(Collection<PortBinding> portBindings) {
        this.portBindings = portBindings;
    }

    public Collection<ExposedPort> getExposedPorts() {
        return exposedPorts;
    }

    public void setExposedPorts(Collection<ExposedPort> exposedPorts) {
        this.exposedPorts = exposedPorts;
    }

    public Boolean getReadonlyRootfs() {
        return ReadonlyRootfs;
    }

    public void setReadonlyRootfs(Boolean readonlyRootfs) {
        this.ReadonlyRootfs = readonlyRootfs;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    public String getWorkingDir() {
        return workingDir;
    }

    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }

    public Boolean getDisableNetwork() {
        return disableNetwork;
    }

    public void setDisableNetwork(Boolean disableNetwork) {
        this.disableNetwork = disableNetwork;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Collection<String> getPortSpecs() {
        return portSpecs;
    }

    public void setPortSpecs(Collection<String> portSpecs) {
        this.portSpecs = portSpecs;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Boolean getTty() {
        return tty;
    }

    public void setTty(Boolean tty) {
        this.tty = tty;
    }

    public Boolean getStdinOpen() {
        return stdinOpen;
    }

    public void setStdinOpen(Boolean stdinOpen) {
        this.stdinOpen = stdinOpen;
    }

    public Boolean getStdinOnce() {
        return stdinOnce;
    }

    public void setStdinOnce(Boolean stdinOnce) {
        this.stdinOnce = stdinOnce;
    }

    public Integer getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(Integer memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public Integer getMemorySwap() {
        return memorySwap;
    }

    public void setMemorySwap(Integer memorySwap) {
        this.memorySwap = memorySwap;
    }

    public Integer getCpuShares() {
        return cpuShares;
    }

    public void setCpuShares(Integer cpuShares) {
        this.cpuShares = cpuShares;
    }

    public String getCpuSet() {
        return cpuSet;
    }

    public void setCpuSet(String cpuSet) {
        this.cpuSet = cpuSet;
    }

    public Boolean getAttachStdin() {
        return attachStdin;
    }

    public void setAttachStdin(Boolean attachStdin) {
        this.attachStdin = attachStdin;
    }

    public Boolean getAttachSterr() {
        return attachSterr;
    }

    public void setAttachSterr(Boolean attachSterr) {
        this.attachSterr = attachSterr;
    }

    public Collection<String> getEnv() {
        return env;
    }

    public void setEnv(Collection<String> env) {
        this.env = env;
    }

    public Collection<String> getCmd() {
        return cmd;
    }

    public void setCmd(Collection<String> cmd) {
        this.cmd = cmd;
    }

    public Collection<String> getDns() {
        return dns;
    }

    public void setDns(Collection<String> dns) {
        this.dns = dns;
    }

    public Collection<String> getVolumes() {
        return volumes;
    }

    public void setVolumes(Collection<String> volumes) {
        this.volumes = volumes;
    }

    public Collection<String> getVolumesFrom() {
        return volumesFrom;
    }

    public void setVolumesFrom(Collection<String> volumesFrom) {
        this.volumesFrom = volumesFrom;
    }

    public Collection<String> getBinds() {
        return binds;
    }

    public void setBinds(Collection<String> binds) {
        this.binds = binds;
    }

    public Collection<Link> getLinks() {
        return links;
    }

    public void setLinks(Collection<Link> links) {
        this.links = links;
    }

    public Boolean getPrivileged() {
        return privileged;
    }

    public void setPrivileged(Boolean privileged) {
        this.privileged = privileged;
    }

    public Boolean getPublishAllPorts() {
        return publishAllPorts;
    }

    public void setPublishAllPorts(Boolean publishAllPorts) {
        this.publishAllPorts = publishAllPorts;
    }

    public String getNetworkMode() {
        return networkMode;
    }

    public void setNetworkMode(String networkMode) {
        this.networkMode = networkMode;
    }

    public Collection<String> getDnsSearch() {
        return dnsSearch;
    }

    public void setDnsSearch(Collection<String> dnsSearch) {
        this.dnsSearch = dnsSearch;
    }

    public Collection<Device> getDevices() {
        return devices;
    }

    public void setDevices(Collection<Device> devices) {
        this.devices = devices;
    }

    public Collection<String> getCapAdd() {
        return capAdd;
    }

    public void setCapAdd(Collection<String> capAdd) {
        this.capAdd = capAdd;
    }

    public Collection<String> getCapDrop() {
        return capDrop;
    }

    public void setCapDrop(Collection<String> capDrop) {
        this.capDrop = capDrop;
    }

    public Collection<String> getExtraHosts() {
        return extraHosts;
    }

    public void setExtraHosts(Collection<String> extraHosts) {
        this.extraHosts = extraHosts;
    }

    public Collection<String> getEntryPoint() {
        return entryPoint;
    }

    public void setEntryPoint(Collection<String> entryPoint) {
        this.entryPoint = entryPoint;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public Boolean getAlwaysPull() {
        return alwaysPull;
    }

    public void setAlwaysPull(Boolean alwaysPull) {
        this.alwaysPull = alwaysPull;
    }

    public RestartPolicy getRestartPolicy() {
        return restartPolicy;
    }

    public void setRestartPolicy(RestartPolicy restartPolicy) {
        this.restartPolicy = restartPolicy;
    }

    public Await getAwait() {
        return await;
    }

    public void setAwait(Await await) {
        this.await = await;
    }

    public boolean hasAwait() {
        return this.await != null;
    }

    public String getExtends() {
        return extendsImage;
    }

    public void setExtends(String extendsImage) {
        this.extendsImage = extendsImage;
    }

    public Collection<BeforeStop> getBeforeStop() {
        return beforeStop;
    }

    public void setBeforeStop(Collection<BeforeStop> beforeStop) {
        this.beforeStop = beforeStop;
    }

    public boolean hasBeforeStop() {
        return this.beforeStop != null && !this.beforeStop.isEmpty();
    }

    public void merge(CubeContainer container) {
        try {
            Field[] fields = CubeContainer.class.getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }

                Object thisVal = field.get(this);
                if (thisVal == null) {
                    Object otherVal = field.get(container);
                    field.set(this, otherVal);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Could not merge objects", e);
        }
    }
}
