package components.membership;

import entities.Member;
import utils.MembershipFactory;
import utils.IMembership;

public class MembershipService {
    public void assignMembership(Member member, String type) {
        IMembership membership = MembershipFactory.create(type);
        member.setMembershipType(type);
        System.out.println("[MembershipComponent]: Assigned " + membership.getBenefits() + " to " + member.getFullName());
    }
}