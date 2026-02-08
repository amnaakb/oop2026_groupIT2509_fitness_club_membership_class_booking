package utils;


class MonthlyMembership implements IMembership {
    @Override public double getPrice() { return 50.0; }
    @Override public String getBenefits() { return "Access for 1 month"; }
}

class YearlyMembership implements IMembership {
    @Override public double getPrice() { return 450.0; }
    @Override public String getBenefits() { return "Access for 1 year + Free Spa"; }
}

class VisitBasedMembership implements IMembership {
    @Override public double getPrice() { return 10.0; }
    @Override public String getBenefits() { return "Pay per visit"; }
}

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