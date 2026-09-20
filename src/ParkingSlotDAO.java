import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ParkingSlotDAO {

    // CREATE
    public void addParkingSlot(ParkingSlot slot) {

        String sql = """
                INSERT INTO parking_slots
                (slot_id, slot_number, slot_type, occupied)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, slot.getSlotId());
            statement.setString(2, slot.getSlotNumber());
            statement.setString(3, slot.getSlotType());
            statement.setBoolean(4, slot.isOccupied());

            statement.executeUpdate();

            System.out.println("Parking slot saved to database.");

        } catch (Exception e) {
            System.out.println("Error adding parking slot.");
            e.printStackTrace();
        }
    }

    // READ
    public List<ParkingSlot> getAllParkingSlots() {

        List<ParkingSlot> slots = new ArrayList<>();

        String sql = "SELECT * FROM parking_slots";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                ParkingSlot slot = new ParkingSlot(
                        resultSet.getInt("slot_id"),
                        resultSet.getString("slot_number"),
                        resultSet.getString("slot_type")
                );

                if (resultSet.getBoolean("occupied")) {
                    slot.occupySlot();
                }

                slots.add(slot);
            }

        } catch (Exception e) {
            System.out.println("Error retrieving parking slots.");
            e.printStackTrace();
        }

        return slots;
    }

    // UPDATE
    public void updateSlotStatus(int slotId, boolean occupied) {

        String sql = """
                UPDATE parking_slots
                SET occupied = ?
                WHERE slot_id = ?
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setBoolean(1, occupied);
            statement.setInt(2, slotId);

            statement.executeUpdate();

            System.out.println("Parking slot status updated.");

        } catch (Exception e) {
            System.out.println("Error updating parking slot.");
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteParkingSlot(int slotId) {

        String sql = "DELETE FROM parking_slots WHERE slot_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, slotId);

            statement.executeUpdate();

            System.out.println("Parking slot deleted from database.");

        } catch (Exception e) {
            System.out.println("Error deleting parking slot.");
            e.printStackTrace();
        }
    }
}