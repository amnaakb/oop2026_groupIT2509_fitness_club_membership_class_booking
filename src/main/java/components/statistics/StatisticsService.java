package components.statistics;

import entities.Member;
import java.util.List;

public class StatisticsService {
    public void printRevenueReport(List<Member> members) {
        System.out.println("--- [StatisticsComponent] Generating Report ---");
        System.out.println("Total Members: " + members.size());
        System.out.println("Status: Report Generated Successfully.");
    }
}