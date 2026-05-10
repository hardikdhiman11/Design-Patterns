package creationalPatterns.builderPattern;


import java.util.List;
import java.util.Map;

/**
 *
 *
 * Design a builder for Docker container specifications.
 *
 *
 *
 *
 * Things clarified from requirements: Builder will take all these parameters.
 *
 * image (required)
 * tag (default latest)
 * name (optional)
 * command (optional, overrides image's CMD)
 * env vars (zero or more)
 * port mappings (zero or more, host:container)
 * volume mounts (zero or more, host:container, with optional read-only flag)
 * network mode (one of: bridge, host, none — default bridge)
 * CPU limit (optional, e.g. "0.5" cores)
 * memory limit (optional, e.g. "512m")
 * user (optional, e.g. "1000:1000")
 * restart policy (no, on-failure, always, unless-stopped — default "no")
 * healthcheck (optional — command, interval, retries)
 *
 *
 *
 *
 * Current scope is cleared we are only concerned with designing the Builder and not other functionality.
 *
 *
 *
 *
 * Entities:
 * - ContainerSpec
 *      - ContainerSpecBuilder
 *
 *
 *
 *
 *
 */


public class BuilderTest {

    static void main() {
        ContainerSpec containerSpec = new ContainerSpec.ContainerSpecBuilder()
                .image("adfshaekfjy")
                .name("erjwhjekhr")
                .tag("erakhr")
                .envVars(List.of("edfrwwueh"))
                .portMappings(null)
                .volumeMounts(null)
                .cpuLimit(0)
                .memoryLimit(1.5)
                .user("user1")
                .build();
        System.out.println(containerSpec.toString());

    }

}

enum NetworkMode{
    BRIDGE,
    HOST,
    NONE
}

enum RestartPolicy{
    NO,
    ON_FAILURE,
    ALWAYS,
    UNLESS_STOPPED
}

enum HealthCheck{
    COMMAND,
    INTERVAL,
    RETRIES
}

class ContainerSpec{

    private String image;
    private String tag;
    private String name;
    private String command;
    private List<String> envVars;
    private Map<String,String> portMappings;
    private Map<String,String> volumeMounts;
    private NetworkMode networkMode;
    private double cpuLimit;
    private double memoryLimit;
    private String user;
    private RestartPolicy restartPolicy;


    public String getImage() {
        return image;
    }

    public String getTag() {
        return tag;
    }

    public String getName() {
        return name;
    }

    public String getCommand() {
        return command;
    }

    public List<String> getEnvVars() {
        return envVars;
    }

    public Map<String, String> getPortMappings() {
        return portMappings;
    }

    public Map<String, String> getVolumeMounts() {
        return volumeMounts;
    }

    public NetworkMode getNetworkMode() {
        return networkMode;
    }

    public double getCpuLimit() {
        return cpuLimit;
    }

    public double getMemoryLimit() {
        return memoryLimit;
    }

    public String getUser() {
        return user;
    }

    public RestartPolicy getRestartPolicy() {
        return restartPolicy;
    }

    @Override
    public String toString() {
        return "ContainerSpec{" +
                "image='" + image + '\'' +
                ", tag='" + tag + '\'' +
                ", name='" + name + '\'' +
                ", command='" + command + '\'' +
                ", envVars=" + envVars +
                ", portMappings=" + portMappings +
                ", volumeMounts=" + volumeMounts +
                ", networkMode=" + networkMode +
                ", cpuLimit=" + cpuLimit +
                ", memoryLimit=" + memoryLimit +
                ", user='" + user + '\'' +
                ", restartPolicy=" + restartPolicy +
                '}';
    }

    public ContainerSpec(ContainerSpecBuilder builder){
        this.image = builder.image;
        this.tag = builder.tag;
        this.name = builder.name;
        this.command = builder.command;
        this.envVars = builder.envVars;
        this.portMappings = builder.portMappings;
        this.volumeMounts = builder.volumeMounts;
        this.networkMode = builder.networkMode;
        this.cpuLimit = builder.cpuLimit;
        this.memoryLimit = builder.memoryLimit;
        this.user = builder.user;
        this.restartPolicy = builder.restartPolicy;
    }



    static class ContainerSpecBuilder{

        private ContainerSpecBuilder(){}

        private String image;
        private String tag;
        private String name;
        private String command;
        private List<String> envVars;
        private Map<String,String> portMappings;
        private Map<String,String> volumeMounts;
        private NetworkMode networkMode;
        private double cpuLimit;
        private double memoryLimit;
        private String user;
        private RestartPolicy restartPolicy;


        public ContainerSpecBuilder image(String image){
            this.image = image;
            return this;
        }
        public ContainerSpecBuilder tag(String tag){
            this.tag = tag;
            return this;
        }
        public ContainerSpecBuilder name(String name){
            this.name = name;
            return this;
        }
        public ContainerSpecBuilder command(String command){
            this.command = command;
            this.image = command;
            return this;
        }
        public ContainerSpecBuilder envVars(List<String> envVars){
            this.envVars = envVars;
            return this;
        }
        public ContainerSpecBuilder portMappings(Map<String,String> portMappings){
            this.portMappings = portMappings;
            return this;
        }
        public ContainerSpecBuilder volumeMounts(Map<String,String> volumeMounts){
            this.volumeMounts = volumeMounts;
            return this;
        }
        public ContainerSpecBuilder networkMode(NetworkMode networkMode){
            this.networkMode = networkMode;
            return this;
        }
        public ContainerSpecBuilder cpuLimit(double cpuLimit){
            if (this.cpuLimit<0)
                throw new IllegalStateException("CPU limit can`t be less then 0");
            this.cpuLimit = cpuLimit;
            return this;
        }
        public ContainerSpecBuilder memoryLimit(double memoryLimit){
            if (this.memoryLimit<0)
                throw new IllegalStateException("Memory limit can`t be less then 0");
            this.memoryLimit = memoryLimit;
            return this;
        }
        public ContainerSpecBuilder user(String user){
            this.user = user;
            return this;
        }
        public ContainerSpecBuilder restartPolicy(RestartPolicy restartPolicy){
            this.restartPolicy = restartPolicy;
            return this;
        }

        public ContainerSpec build(){
            if (this.image == null) throw new IllegalStateException("Image can`t be null");
            if (this.tag == null) this.tag = "latest";
            if (this.networkMode == null) this.networkMode = NetworkMode.NONE;
            if (this.restartPolicy == null) this.restartPolicy = RestartPolicy.NO;

            return new ContainerSpec(this);
        }

    }


}



