abstract public class Plane implements Vehicable, Honkable, Pilotable {
    final String vehicleType = "airplane";

    public void honk() {
        System.out.println("airplane honk");
    }

    public String getVehicleType(){
        return vehicleType;
    }
}
