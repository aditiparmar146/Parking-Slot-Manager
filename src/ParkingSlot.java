public class ParkingSlot {

    private int slotId;
    private String slotNumber;
    private String slotType;
    private boolean occupied;

    public ParkingSlot(int slotId, String slotNumber, String slotType) {
        this.slotId = slotId;
        this.slotNumber = slotNumber;
        this.slotType = slotType;
        this.occupied = false;
    }

    public int getSlotId() {
        return slotId;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public String getSlotType() {
        return slotType;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void occupySlot() {
        occupied = true;
    }

    public void releaseSlot() {
        occupied = false;
    }

    @Override
    public String toString() {
        String status = occupied ? "Occupied" : "Available";

        return "Slot ID: " + slotId +
                ", Number: " + slotNumber +
                ", Type: " + slotType +
                ", Status: " + status;
    }
}
