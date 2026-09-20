import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {

    // CREATE
    public void addVehicle(Vehicle vehicle) {
         if (!Validation.isValidVehicleNumber(vehicle.getVehicleNumber())) {
        System.out.println("Invalid vehicle number.");
        return;
    }

    if (!Validation.isValidVehicleType(vehicle.getVehicleType())) {
        System.out.println("Invalid vehicle type.");
        return;
    }

    if (getVehicleByNumber(vehicle.getVehicleNumber()) != null) {
    System.out.println("Vehicle already exists.");
    return;
    }
        String sql = """
                INSERT INTO vehicles
                (vehicle_id, vehicle_number, vehicle_type)
                VALUES (?, ?, ?)
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, vehicle.getVehicleId());
            statement.setString(2, vehicle.getVehicleNumber());
            statement.setString(3, vehicle.getVehicleType());

            statement.executeUpdate();

            System.out.println("Vehicle saved to database.");

        } catch (Exception e) {
            System.out.println("Error adding vehicle.");
            e.printStackTrace();
        }
    }

    // READ
    public List<Vehicle> getAllVehicles() {

        List<Vehicle> vehicles = new ArrayList<>();

        String sql = "SELECT * FROM vehicles";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Vehicle vehicle = new Vehicle(
                        resultSet.getInt("vehicle_id"),
                        resultSet.getString("vehicle_number"),
                        resultSet.getString("vehicle_type")
                );

                vehicles.add(vehicle);
            }

        } catch (Exception e) {
            System.out.println("Error retrieving vehicles.");
            e.printStackTrace();
        }

        return vehicles;
    }

    // UPDATE
    public void updateVehicle(Vehicle vehicle) {

        String sql = """
                UPDATE vehicles
                SET vehicle_number = ?, vehicle_type = ?
                WHERE vehicle_id = ?
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, vehicle.getVehicleNumber());
            statement.setString(2, vehicle.getVehicleType());
            statement.setInt(3, vehicle.getVehicleId());

            statement.executeUpdate();

            System.out.println("Vehicle updated in database.");

        } catch (Exception e) {
            System.out.println("Error updating vehicle.");
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteVehicle(int vehicleId) {

        String sql = "DELETE FROM vehicles WHERE vehicle_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, vehicleId);

            statement.executeUpdate();

            System.out.println("Vehicle deleted from database.");

        } catch (Exception e) {
            System.out.println("Error deleting vehicle.");
            e.printStackTrace();
        }
    }
    public Vehicle getVehicleByNumber(String vehicleNumber) {

    String sql = "SELECT * FROM vehicles WHERE vehicle_number = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, vehicleNumber);

        try (ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                return new Vehicle(
                        resultSet.getInt("vehicle_id"),
                        resultSet.getString("vehicle_number"),
                        resultSet.getString("vehicle_type")
                );
            }
        }

    } catch (Exception e) {
        System.out.println("Error checking vehicle.");
        e.printStackTrace();
    }

    return null;
}
}