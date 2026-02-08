package entities;

public class GymConfig {
    private static GymConfig instance;
    private String gymName;
    private String version;

    private GymConfig() {
        this.gymName = "Iron Fitness Club";
        this.version = "2.0 (Milestone 2)";
    }

    public static GymConfig getInstance() {
        if (instance == null) {
            instance = new GymConfig();
        }
        return instance;
    }

    public String getGymName() { return gymName; }

    public String getVersion() { return version; }

}

