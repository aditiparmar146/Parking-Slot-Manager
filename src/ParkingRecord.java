import java.time.LocalDateTime;

public class ParkingRecord {

    private int recordId;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double parkingFee;

    public ParkingRecord(int recordId, Vehicle vehicle,
                         ParkingSlot parkingSlot,
                         LocalDateTime entryTime) {

        this.recordId = recordId;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.entryTime = entryTime;
        this.exitTime = null;
        this.parkingFee = 0.0;
    }

    public int getRecordId() {
        return recordId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public double getParkingFee() {
        return parkingFee;
    }

    public void completeParking(LocalDateTime exitTime, double parkingFee) {
        this.exitTime = exitTime;
        this.parkingFee = parkingFee;
    }

    @Override
    public String toString() {
        return "Record ID: " + recordId +
                "\nVehicle: " + vehicle.getVehicleNumber() +
                "\nSlot: " + parkingSlot.getSlotNumber() +
                "\nEntry Time: " + entryTime +
                "\nExit Time: " + exitTime +
                "\nParking Fee: ₹" + parkingFee;
    }
}
