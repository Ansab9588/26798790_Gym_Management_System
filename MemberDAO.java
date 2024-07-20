import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    public void addMember(Member member) {
        String sql = "INSERT INTO Member (name, contact_number, email, membership_type) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, member.getName());
            stmt.setString(2, member.getContactNumber());
            stmt.setString(3, member.getEmail());
            stmt.setString(4, member.getMembershipType());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Member getMember(int memberId) {
        String sql = "SELECT * FROM Member WHERE member_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, memberId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Member member = new Member();
                member.setMemberId(rs.getInt("member_id"));
                member.setName(rs.getString("name"));
                member.setContactNumber(rs.getString("contact_number"));
                member.setEmail(rs.getString("email"));
                member.setMembershipType(rs.getString("membership_type"));
                return member;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateMember(Member member) {
        String sql = "UPDATE Member SET name = ?, contact_number = ?, email = ?, membership_type = ? WHERE member_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, member.getName());
            stmt.setString(2, member.getContactNumber());
            stmt.setString(3, member.getEmail());
            stmt.setString(4, member.getMembershipType());
            stmt.setInt(5, member.getMemberId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMember(int memberId) {
        String sql = "DELETE FROM Member WHERE member_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, memberId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
