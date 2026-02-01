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

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // ---------------------------------------------------------
        // 1. Singleton (Одиночка)
        // ---------------------------------------------------------
        System.out.println("=== 1. Singleton Pattern ===");
        GymConfig config = GymConfig.getInstance();
        System.out.println("Gym Name: " + config.getGymName());
        System.out.println("System Version: " + config.getVersion());


        // ---------------------------------------------------------
        // Подключение к Базе Данных
        // ---------------------------------------------------------
        System.out.println("\n--- Connecting to DB ---");
        IDB db = new PostgresDB();
        MemberRepository repo = new MemberRepositoryImpl(db);

        // Пытаемся получить людей из базы
        List<Member> allMembers = repo.getAll();
        System.out.println("Loaded members from DB: " + allMembers.size());

        // Если база пустая (или не подключилась), создадим фейковые данные для демонстрации
        if (allMembers.isEmpty()) {
            System.out.println("(Database is empty/unavailable, using test data for demonstration)");
            allMembers = new ArrayList<>();
            allMembers.add(new Member(1, "Alice", "alice@test.com", "123", "Monthly"));
            allMembers.add(new Member(2, "Bob", "bob@test.com", "456", "Yearly"));
            allMembers.add(new Member(3, "Charlie", "charlie@test.com", "789", "Monthly"));
        }


        // ---------------------------------------------------------
        // 2. Generics (Фильтр)
        // ---------------------------------------------------------
        System.out.println("\n=== 2. Generics Pattern (Filter) ===");
        // Ищем только тех, у кого абонемент "Monthly"
        List<Member> monthlyUsers = FilterUtils.filter(allMembers,
                m -> "Monthly".equalsIgnoreCase(m.getMembershipType())
        );

        System.out.println("Found " + monthlyUsers.size() + " users with Monthly pass:");
        for (Member m : monthlyUsers) {
            System.out.println(" - " + m.getFullName());
        }


        // ---------------------------------------------------------
        // 3. Factory (Фабрика)
        // ---------------------------------------------------------
        System.out.println("\n=== 3. Factory Pattern (Benefits) ===");

        for (Member m : monthlyUsers) {
            // Фабрика создает объект нужного типа на основе строки из базы
            IMembership card = MembershipFactory.create(m.getMembershipType());

            System.out.println("User: " + m.getFullName());
            System.out.println("   Price: $" + card.getPrice());
            System.out.println("   Benefit: " + card.getBenefits());
        }


        // ---------------------------------------------------------
        // 4. Builder (Строитель)
        // ---------------------------------------------------------
        System.out.println("\n=== 4. Builder Pattern (Training Plan) ===");

        if (!allMembers.isEmpty()) {
            Member firstMember = allMembers.get(0);

            // Создаем сложный объект плана
            TrainingPlan myPlan = new TrainingPlan.Builder()
                    .setGoal("Get Stronger")
                    .setWeeks(10)
                    .setTrainer(true)
                    .build();

            System.out.println("Created plan for " + firstMember.getFullName() + ":");
            System.out.println(myPlan.toString());
        }
    }
}