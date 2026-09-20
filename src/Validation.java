public class Validation {

    public static boolean isValidVehicleNumber(String vehicleNumber) {

        if (vehicleNumber == null || vehicleNumber.isEmpty()) {
            return false;
        }

        return vehicleNumber.matches("[A-Z]{2}[0-9]{2}[A-Z]{1,2}[0-9]{4}");
    }

    public static boolean isValidVehicleType(String vehicleType) {

        if (vehicleType == null || vehicleType.isEmpty()) {
            return false;
        }

        return vehicleType.equalsIgnoreCase("Car")
                || vehicleType.equalsIgnoreCase("Bike");
    }
}
