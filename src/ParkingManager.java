import java.util.ArrayList;
import java.util.List;

public class ParkingManager {

    private List<ParkingSlot> parkingSlots;
    private List<ParkingRecord> parkingRecords;
    private List<Vehicle> vehicles;

    public ParkingManager() {
        parkingSlots = new ArrayList<>();
        parkingRecords = new ArrayList<>();
        vehicles = new ArrayList<>();
    }

    // =========================
    // CREATE
    // =========================

    // Add a vehicle
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added successfully.");
    }

    // Add a parking slot
    public void addParkingSlot(ParkingSlot slot) {
        parkingSlots.add(slot);
        System.out.println("Parking slot added successfully.");
    }

    // =========================
    // READ
    // =========================

    // Display all vehicles
    public void displayVehicles() {

        System.out.println("\n--- Registered Vehicles ---");

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles registered.");
            return;
        }

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    // Display all parking slots
    public void displayParkingSlots() {

        System.out.println("\n--- Parking Slots ---");

        if (parkingSlots.isEmpty()) {
            System.out.println("No parking slots available.");
            return;
        }

        for (ParkingSlot slot : parkingSlots) {
            System.out.println(slot);
        }
    }

    // =========================
    // UPDATE
    // =========================

    // Update vehicle details
    public boolean updateVehicle(int vehicleId, String newVehicleNumber,
                                 String newVehicleType) {

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getVehicleId() == vehicleId) {

                vehicle.setVehicleNumber(newVehicleNumber);
                vehicle.setVehicleType(newVehicleType);

                System.out.println("Vehicle updated successfully.");
                return true;
            }
        }

        System.out.println("Vehicle not found.");
        return false;
    }

    // =========================
    // DELETE
    // =========================

    // Delete a vehicle
    public boolean deleteVehicle(int vehicleId) {

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getVehicleId() == vehicleId) {

                vehicles.remove(vehicle);

                System.out.println("Vehicle deleted successfully.");
                return true;
            }
        }

        System.out.println("Vehicle not found.");
        return false;
    }

    // =========================
    // PARK VEHICLE
    // =========================

    public boolean parkVehicle(Vehicle vehicle) {

        for (ParkingSlot slot : parkingSlots) {

            if (!slot.isOccupied()
                    && slot.getSlotType()
                    .equalsIgnoreCase(vehicle.getVehicleType())) {

                slot.occupySlot();

                ParkingRecord record = new ParkingRecord(
                        parkingRecords.size() + 1,
                        vehicle,
                        slot,
                        java.time.LocalDateTime.now()
                );

                parkingRecords.add(record);

                System.out.println("Vehicle parked successfully.");
                System.out.println(
                        "Assigned Slot: " + slot.getSlotNumber()
                );

                return true;
            }
        }

        System.out.println("No suitable parking slot available.");
        return false;
    }

    // =========================
    // REMOVE VEHICLE FROM SLOT
    // =========================

    public boolean removeVehicle(String vehicleNumber) {

        for (ParkingRecord record : parkingRecords) {

            if (record.getVehicle()
                    .getVehicleNumber()
                    .equalsIgnoreCase(vehicleNumber)
                    && record.getExitTime() == null) {

                record.getParkingSlot().releaseSlot();

                record.completeParking(
                        java.time.LocalDateTime.now(),
                        50.0
                );

                System.out.println("Vehicle removed successfully.");
                System.out.println(
                        "Slot Released: "
                        + record.getParkingSlot().getSlotNumber()
                );

                return true;
            }
        }

        System.out.println("Vehicle not found.");
        return false;
    }

    // =========================
    // DISPLAY PARKED VEHICLES
    // =========================

    public void displayParkedVehicles() {

        System.out.println("\n--- Parked Vehicles ---");

        boolean found = false;

        for (ParkingRecord record : parkingRecords) {

            if (record.getExitTime() == null) {

                System.out.println(record);
                System.out.println();

                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles are currently parked.");
        }
    }
}