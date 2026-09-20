public class Main {

    public static void main(String[] args) {

        ParkingManager manager = new ParkingManager();

        // =========================
        // CREATE
        // =========================

        Vehicle car = new Vehicle(
                1,
                "KA01AB1234",
                "Car"
        );

        Vehicle bike = new Vehicle(
                2,
                "KA05XY5678",
                "Bike"
        );

        manager.addVehicle(car);
        manager.addVehicle(bike);

        ParkingSlot slot1 = new ParkingSlot(
                1,
                "A01",
                "Car"
        );

        ParkingSlot slot2 = new ParkingSlot(
                2,
                "A02",
                "Car"
        );

        ParkingSlot slot3 = new ParkingSlot(
                3,
                "B01",
                "Bike"
        );

        manager.addParkingSlot(slot1);
        manager.addParkingSlot(slot2);
        manager.addParkingSlot(slot3);

        // =========================
        // READ
        // =========================

        manager.displayVehicles();

        manager.displayParkingSlots();

        // =========================
        // PARK VEHICLES
        // =========================

        System.out.println("\n--- Parking Vehicles ---");

        manager.parkVehicle(car);
        manager.parkVehicle(bike);

        // =========================
        // UPDATE
        // =========================

        System.out.println("\n--- Updating Vehicle ---");

        manager.updateVehicle(
                1,
                "KA01ZZ9999",
                "Car"
        );

        manager.displayVehicles();

        // =========================
        // DELETE
        // =========================

        System.out.println("\n--- Deleting Vehicle ---");

        manager.deleteVehicle(2);

        manager.displayVehicles();

        // =========================
        // PARKED VEHICLES
        // =========================

        manager.displayParkedVehicles();
    }
}