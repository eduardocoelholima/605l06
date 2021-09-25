abstract public class Car implements Vehicable, Honkable, Driveable {
    int numberOfWheels = 4;

    final String vehicleType = "car";

    public void honk() {
        System.out.println("car honk");
    }

    public String getVehicleType(){
        return vehicleType;
    }
}
