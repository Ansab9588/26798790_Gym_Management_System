import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassScheduleDAO {
    public void addClassSchedule(ClassSchedule classSchedule) {
        String sql = "INSERT INTO ClassSchedule (class_name, trainer_id, day_of_week, start_time, end_time) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, classSchedule.getClassName());
            stmt.setInt(2, classSchedule.getTrainerId());
            stmt.setString(3, classSchedule.getDayOfWeek());
            stmt.setString(4, classSchedule.getStartTime());
            stmt.setString(5, classSchedule.getEndTime());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ClassSchedule getClassSchedule(int scheduleId) {
        String sql = "SELECT * FROM ClassSchedule WHERE schedule_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, scheduleId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ClassSchedule classSchedule = new ClassSchedule();
                classSchedule.setScheduleId(rs.getInt("schedule_id"));
                classSchedule.setClassName(rs.getString("class_name"));
                classSchedule.setTrainerId(rs.getInt("trainer_id"));
                classSchedule.setDayOfWeek(rs.getString("day_of_week"));
                classSchedule.setStartTime(rs.getString("start_time"));
                classSchedule.setEndTime(rs.getString("end_time"));
                return classSchedule;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateClassSchedule(ClassSchedule classSchedule) {
        String sql = "UPDATE ClassSchedule SET class_name = ?, trainer_id = ?, day_of_week = ?, start_time = ?, end_time = ? WHERE schedule_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, classSchedule.getClassName());
            stmt.setInt(2, classSchedule.getTrainerId());
            stmt.setString(3, classSchedule.getDayOfWeek());
            stmt.setString(4, classSchedule.getStartTime());
            stmt.setString(5, classSchedule.getEndTime());
            stmt.setInt(6, classSchedule.getScheduleId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClassSchedule(int scheduleId) {
        String sql = "DELETE FROM ClassSchedule WHERE schedule_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, scheduleId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ClassSchedule> getClassSchedulesByTrainer(int trainerId) {
       
        throw new UnsupportedOperationException("Unimplemented method 'getClassSchedulesByTrainer'");
    }
}
