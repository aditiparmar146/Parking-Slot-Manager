import java.util.ArrayList;
import java.util.List;

public class ParkingManager {

    private List<ParkingSlot> parkingSlots;
    private List<ParkingRecord> parkingRecords;

    public ParkingManager() {
        parkingSlots = new ArrayList<>();
        parkingRecords = new ArrayList<>();
    }

    
    public void addParkingSlot(ParkingSlot slot) {
        parkingSlots.add(slot);
    }

    
    public boolean parkVehicle(Vehicle vehicle) {

        for (ParkingSlot slot : parkingSlots) {

            if (!slot.isOccupied()
                    && slot.getSlotType().equalsIgnoreCase(vehicle.getVehicleType())) {

                slot.occupySlot();

                ParkingRecord record = new ParkingRecord(
                        parkingRecords.size() + 1,
                        vehicle,
                        slot,
                        java.time.LocalDateTime.now()
                );

                parkingRecords.add(record);

                System.out.println("Vehicle parked successfully.");
                System.out.println("Assigned Slot: " + slot.getSlotNumber());

                return true;
            }
        }

        System.out.println("No suitable parking slot available.");
        return false;
    }

   
    public boolean removeVehicle(String vehicleNumber) {

        for (ParkingRecord record : parkingRecords) {

            if (record.getVehicle().getVehicleNumber()
                    .equalsIgnoreCase(vehicleNumber)
                    && record.getExitTime() == null) {

                record.getParkingSlot().releaseSlot();

                record.completeParking(
                        java.time.LocalDateTime.now(),
                        50.0
                );

                System.out.println("Vehicle removed successfully.");
                System.out.println("Slot Released: "
                        + record.getParkingSlot().getSlotNumber());

                return true;
            }
        }

        System.out.println("Vehicle not found.");
        return false;
    }


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
