package entities;

public class TrainingPlan {
    private String goal;
    private int weeks;
    private boolean hasTrainer;

    private TrainingPlan(Builder builder) {
        this.goal = builder.goal;
        this.weeks = builder.weeks;
        this.hasTrainer = builder.hasTrainer;
    }

    @Override
    public String toString() {
        return "Plan: Goal=" + goal + ", Weeks=" + weeks + ", Trainer=" + hasTrainer;
    }

    public static class Builder {
        private String goal;
        private int weeks;
        private boolean hasTrainer;

        public Builder setGoal(String goal) {
            this.goal = goal;
            return this;
        }

        public Builder setWeeks(int weeks) {
            this.weeks = weeks;
            return this;
        }

        public Builder setTrainer(boolean hasTrainer) {
            this.hasTrainer = hasTrainer;
            return this;
        }

        public TrainingPlan build() {
            return new TrainingPlan(this);
        }
    }
}