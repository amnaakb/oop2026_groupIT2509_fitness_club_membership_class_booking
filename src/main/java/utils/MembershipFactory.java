package utils;

// ВАЖНО: Тут больше нет interface IMembership, он в другом файле!

// Реализация: Месячный (оставляем)
class MonthlyMembership implements IMembership {
    @Override public double getPrice() { return 50.0; }
    @Override public String getBenefits() { return "Access for 1 month"; }
}

// Реализация: Годовой (оставляем)
class YearlyMembership implements IMembership {
    @Override public double getPrice() { return 450.0; }
    @Override public String getBenefits() { return "Access for 1 year + Free Spa"; }
}

// Реализация: Обычный (оставляем)
class VisitBasedMembership implements IMembership {
    @Override public double getPrice() { return 10.0; }
    @Override public String getBenefits() { return "Pay per visit"; }
}

// Фабрика (оставляем)
public class MembershipFactory {
    public static IMembership create(String type) {
        if (type == null) return new VisitBasedMembership();

        switch (type.toLowerCase()) {
            case "monthly": return new MonthlyMembership();
            case "yearly":  return new YearlyMembership();
            default:        return new VisitBasedMembership();
        }
    }
}