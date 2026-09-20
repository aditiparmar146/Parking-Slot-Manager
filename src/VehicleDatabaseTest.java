import java.util.List;

public class VehicleDatabaseTest {

    public static void main(String[] args) {

        VehicleDAO vehicleDAO = new VehicleDAO();

        // CREATE
        Vehicle vehicle = new Vehicle(
                1,
                "KA01AB1234",
                "Car"
        );

        vehicleDAO.addVehicle(vehicle);

        // READ
        System.out.println("\n--- Vehicles in Database ---");

        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();

        for (Vehicle v : vehicles) {
            System.out.println(v);
        }

        // UPDATE
        System.out.println("\n--- Updating Vehicle ---");

        vehicle.setVehicleNumber("KA01ZZ9999");
        vehicleDAO.updateVehicle(vehicle);

        // READ again
        System.out.println("\n--- Vehicles After Update ---");

        vehicles = vehicleDAO.getAllVehicles();

        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }
}