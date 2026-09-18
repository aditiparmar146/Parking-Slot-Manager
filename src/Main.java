public class Main {

    public static void main(String[] args) {

        // Create parking manager
        ParkingManager manager = new ParkingManager();

        // Create parking slots
        ParkingSlot slot1 = new ParkingSlot(1, "A01", "Car");
        ParkingSlot slot2 = new ParkingSlot(2, "A02", "Car");
        ParkingSlot slot3 = new ParkingSlot(3, "B01", "Bike");

        // Add slots to parking system
        manager.addParkingSlot(slot1);
        manager.addParkingSlot(slot2);
        manager.addParkingSlot(slot3);

        // Create vehicles
        Vehicle car = new Vehicle(
                1,
                "KA01AB1234",
                "Car"
        );

        Vehicle car2 = new Vehicle(
                3,
                "KA03CD9999",
                "Car"
        );

        Vehicle car3 = new Vehicle(
                4,
                "KA04EF8888",
                "Car"
        );

        Vehicle bike = new Vehicle(
                2,
                "KA05XY5678",
                "Bike"
        );

        // Park vehicles
        System.out.println("--- Parking Vehicles ---");

        manager.parkVehicle(car);
        manager.parkVehicle(car2);
        manager.parkVehicle(car3);
        manager.parkVehicle(bike);

        // Display parked vehicles
        manager.displayParkedVehicles();

        // Remove car
        System.out.println("--- Vehicle Exit ---");

        manager.removeVehicle("KA01AB1234");

        // Display again
        manager.displayParkedVehicles();
    }
}