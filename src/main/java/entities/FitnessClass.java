package entities;

public class FitnessClass {
    private int id;
    private String name;
    private String instructor;
    private String schedule;
    private int capacity;

    public FitnessClass() {
    }

    public FitnessClass(int id, String name, String instructor, String schedule, int capacity) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.schedule = schedule;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "FitnessClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instructor='" + instructor + '\'' +
                ", schedule='" + schedule + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}

