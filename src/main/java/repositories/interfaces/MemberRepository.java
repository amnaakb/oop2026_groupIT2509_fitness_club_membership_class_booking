package repositories.interfaces;

import entities.Member;

import java.util.List;

public interface MemberRepository {

    boolean create(Member member);

    List<Member> getAll();

    Member getById(int id);
}
