import java.util.List;

public class ParkingSlotDatabaseTest {

    public static void main(String[] args) {

        ParkingSlotDAO slotDAO = new ParkingSlotDAO();

        // CREATE
        ParkingSlot slot = new ParkingSlot(
                1,
                "A1",
                "Car"
        );

        slotDAO.addParkingSlot(slot);

        // READ
        System.out.println("\n--- Parking Slots ---");

        List<ParkingSlot> slots = slotDAO.getAllParkingSlots();

        for (ParkingSlot s : slots) {
            System.out.println(s);
        }

        // UPDATE
        System.out.println("\n--- Updating Slot ---");

        slotDAO.updateSlotStatus(1, true);

        // READ again
        System.out.println("\n--- Parking Slots After Update ---");

        slots = slotDAO.getAllParkingSlots();

        for (ParkingSlot s : slots) {
            System.out.println(s);
        }
    }
}
