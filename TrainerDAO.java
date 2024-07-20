import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainerDAO {
    public void addTrainer(Trainer trainer) {
        String sql = "INSERT INTO Trainer (name, contact_number, email, speciality) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trainer.getName());
            stmt.setString(2, trainer.getContactNumber());
            stmt.setString(3, trainer.getEmail());
            stmt.setString(4, trainer.getSpeciality());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Trainer getTrainer(int trainerId) {
        String sql = "SELECT * FROM Trainer WHERE trainer_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, trainerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Trainer trainer = new Trainer();
                trainer.setTrainerId(rs.getInt("trainer_id"));
                trainer.setName(rs.getString("name"));
                trainer.setContactNumber(rs.getString("contact_number"));
                trainer.setEmail(rs.getString("email"));
                trainer.setSpeciality(rs.getString("speciality"));
                return trainer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateTrainer(Trainer trainer) {
        String sql = "UPDATE Trainer SET name = ?, contact_number = ?, email = ?, speciality = ? WHERE trainer_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trainer.getName());
            stmt.setString(2, trainer.getContactNumber());
            stmt.setString(3, trainer.getEmail());
            stmt.setString(4, trainer.getSpeciality());
            stmt.setInt(5, trainer.getTrainerId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTrainer(int trainerId) {
        String sql = "DELETE FROM Trainer WHERE trainer_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, trainerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
