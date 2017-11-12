import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Race {
    static boolean isRaining;
    private ObservableList<Vehicle> vehicle = FXCollections.observableArrayList();
    private Car car;
    private Motorcycle motorcycle;
    private Truck truck;
    private int numberOfVehicles;

    public List<Vehicle> getVehicle() {
        return vehicle;
    }

    public ObservableList<Vehicle> getVehicles() {
        return this.vehicle;
    }

    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }


    public void createVehicles(boolean isCarChecked, boolean isMotoChecked, boolean isTruckChecked) {
        Motorcycle.setNameNumber(1);
        Truck.clearTrucknames();
        for (int i = 0; i < numberOfVehicles; i++) {
            if (isCarChecked) {
                car = new Car();
                vehicle.add(car);
            }
            if (isMotoChecked) {
                motorcycle = new Motorcycle();
                vehicle.add(motorcycle);
            }
            if (isTruckChecked) {
                truck = new Truck();
                vehicle.add(truck);
            }
        }
    }

    public void simulateRace() {

        for (int i = 0; i < vehicle.size(); i++) {
            for (int hour = 0; hour < 50; hour++) {
                RandomGenerator.isRaining();
                this.vehicle.get(i).moveForAnHour();
            }
        }
    }

    public void printResults() {
        for (int i = 0; i < vehicle.size(); i++) {
            System.out.println(String.format("%s travelled : %s km",
                    vehicle.get(i).getName(),
                    vehicle.get(i).getDistanceTraveled()));

        }
        System.out.println(RandomGenerator.chanceOfRain);
    }
}
