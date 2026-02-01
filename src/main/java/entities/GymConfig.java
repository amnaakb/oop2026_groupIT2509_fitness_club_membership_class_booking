package entities;

public class GymConfig {
    private static GymConfig instance;
    private String gymName;
    private String version; // 1. Добавили поле версии

    // Приватный конструктор
    private GymConfig() {
        this.gymName = "Iron Fitness Club";
        this.version = "2.0 (Milestone 2)"; // 2. Задали версию
    }

    public static GymConfig getInstance() {
        if (instance == null) {
            instance = new GymConfig();
        }
        return instance;
    }

    public String getGymName() { return gymName; }

    // 3. Добавили метод, на который ругается Main
    public String getVersion() { return version; }

}

