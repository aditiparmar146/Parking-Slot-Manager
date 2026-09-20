public class ValidationTest {

    public static void main(String[] args) {

        VehicleDAO vehicleDAO = new VehicleDAO();

        System.out.println("--- Validation Tests ---");

        // Valid vehicle
        Vehicle validVehicle = new Vehicle(
                2,
                "KA02AB1234",
                "Car"
        );

        vehicleDAO.addVehicle(validVehicle);

        // Duplicate vehicle number
        Vehicle duplicateVehicle = new Vehicle(
                3,
                "KA02AB1234",
                "Car"
        );

        vehicleDAO.addVehicle(duplicateVehicle);

        // Invalid vehicle number
        Vehicle invalidVehicle = new Vehicle(
                4,
                "12345",
                "Car"
        );

        vehicleDAO.addVehicle(invalidVehicle);

        // Invalid vehicle type
        Vehicle invalidType = new Vehicle(
                5,
                "KA03CD5678",
                "Truck"
        );

        vehicleDAO.addVehicle(invalidType);
    }
}