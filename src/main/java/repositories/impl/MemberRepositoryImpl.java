package repositories.impl;

import data.interfaces.IDB;
import entities.Member;
import repositories.interfaces.MemberRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberRepositoryImpl implements MemberRepository {

    private final IDB db;

    public MemberRepositoryImpl(IDB db) {
        this.db = db;
    }

    @Override
    public boolean create(Member member) {
        String sql = "INSERT INTO members(full_name, email, phone, membership_type) VALUES (?, ?, ?, ?)";

        try (Connection con = db.getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, member.getFullName());
            st.setString(2, member.getEmail());
            st.setString(3, member.getPhone());
            st.setString(4, member.getMembershipType());

            st.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Member> getAll() {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members";

        try (Connection con = db.getConnection();
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getInt("id"));
                member.setFullName(rs.getString("full_name"));
                member.setEmail(rs.getString("email"));
                member.setPhone(rs.getString("phone"));
                member.setMembershipType(rs.getString("membership_type"));

                members.add(member);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return members;
    }

    @Override
    public Member getById(int id) {
        String sql = "SELECT * FROM members WHERE id = ?";

        try (Connection con = db.getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, id);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Member member = new Member();
                    member.setId(rs.getInt("id"));
                    member.setFullName(rs.getString("full_name"));
                    member.setEmail(rs.getString("email"));
                    member.setPhone(rs.getString("phone"));
                    member.setMembershipType(rs.getString("membership_type"));

                    return member;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

