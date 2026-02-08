import data.interfaces.IDB;
import data.postgres.PostgresDB;
import repositories.impl.MemberRepositoryImpl;
import repositories.interfaces.MemberRepository;
import entities.Member;
import entities.GymConfig;
import entities.TrainingPlan;
import utils.FilterUtils;
import utils.MembershipFactory;
import utils.IMembership;

import components.membership.MembershipService;
import components.booking.BookingService;
import components.notification.NotificationService;
import components.statistics.StatisticsService;

import java.util.List;
import java.util.ArrayList;

public class Main {

    private static Member createMember(int id, String name, String email, String phone, String type) {
        Member m = new Member();
        m.setId(id);
        m.setFullName(name);
        m.setEmail(email);
        m.setPhone(phone);
        m.setMembershipType(type);
        return m;
    }

    public static void main(String[] args) {

        System.out.println("=== 1. Singleton Pattern ===");
        GymConfig config = GymConfig.getInstance();
        System.out.println("Gym Name: " + config.getGymName());

        System.out.println("\n--- Connecting to DB ---");
        IDB db = new PostgresDB();
        MemberRepository repo = new MemberRepositoryImpl(db);

        List<Member> allMembers = new ArrayList<>();
        try {
            allMembers = repo.getAll();
            System.out.println("Loaded members from DB: " + allMembers.size());
        } catch (Exception e) {
            System.out.println("DB Error (ignored for demo): " + e.getMessage());
        }

        if (allMembers.isEmpty()) {
            System.out.println("(Database is empty/unavailable, using test data)");
            allMembers.add(createMember(1, "Alice", "alice@test.com", "123", "Monthly"));
            allMembers.add(createMember(2, "Bob", "bob@test.com", "456", "Yearly"));
            allMembers.add(createMember(3, "Charlie", "charlie@test.com", "789", "Monthly"));
        }

        System.out.println("\n=== 2. Generics Pattern (Filter) ===");
        List<Member> monthlyUsers = FilterUtils.filter(allMembers,
                m -> "Monthly".equalsIgnoreCase(m.getMembershipType())
        );
        for (Member m : monthlyUsers) {
            System.out.println(" - " + m.getFullName());
        }

        System.out.println("\n=== 3. Factory Pattern (Benefits) ===");
        for (Member m : monthlyUsers) {
            IMembership card = MembershipFactory.create(m.getMembershipType());
            if (card != null) {
                System.out.println("User: " + m.getFullName());
                System.out.println("   Price: $" + card.getPrice());
                // ИСПРАВЛЕНИЕ: getBenefits() вместо getDescription()
                System.out.println("   Benefit: " + card.getBenefits());
            }
        }

        System.out.println("\n=== 4. Builder Pattern (Training Plan) ===");
        if (!allMembers.isEmpty()) {
            Member firstMember = allMembers.get(0);

            TrainingPlan.Builder builder = new TrainingPlan.Builder()
                    .setGoal("Get Stronger");

            builder.setWeeks(10);

            TrainingPlan myPlan = builder.setTrainer(true).build();

            System.out.println("Created plan for " + firstMember.getFullName() + ":");
            System.out.println(myPlan.toString());
        }

        System.out.println("\n=== 5. Components & Principles (REP, CCP, CRP) ===");
        MembershipService membershipService = new MembershipService();
        BookingService bookingService = new BookingService();
        NotificationService notificationService = new NotificationService();
        StatisticsService statsService = new StatisticsService();

        if (!allMembers.isEmpty()) {
            Member user = allMembers.get(0);
            membershipService.assignMembership(user, "Yearly");
            notificationService.sendEmail(user.getEmail(), "Welcome!");
            bookingService.bookClass(user, "Morning Yoga");
            statsService.printRevenueReport(allMembers);
        }
    }
}