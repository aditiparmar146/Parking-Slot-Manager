import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle(
                1,
                "KA01AB1234",
                "Car"
        );

        ParkingSlot slot = new ParkingSlot(
                1,
                "A01",
                "Car"
        );

        slot.occupySlot();

        ParkingRecord record = new ParkingRecord(
                1,
                vehicle,
                slot,
                LocalDateTime.now()
        );

        System.out.println(vehicle);
        System.out.println();

        System.out.println(slot);
        System.out.println();

        System.out.println(record);
    }
}
