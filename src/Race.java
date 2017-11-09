

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Race  {
    static boolean isRaining ;// 30% chance of rain every hour


    public List<Vehicle> getVehicle() {
        return vehicle;
    }

    private List<Vehicle> vehicle = new ArrayList<>();

    private Car car;
    private Motorcycle motorcycle;
    private Truck truck;

    private int numberOfVehicles = 10;

    public int getNumberOfVehicles() {
        return this.numberOfVehicles;
    }

    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }


    public void createVehicles(){
        for (int i = 0; i <numberOfVehicles ; i++){
            car = new Car();
            truck = new Truck();
            motorcycle = new Motorcycle();
            vehicle.add(car);
            vehicle.add(truck);
            vehicle.add(motorcycle);
        }

    }

    public void simulateRace(){
        Motorcycle.setNameNumber(1);
        for (int i = 0; i < vehicle.size(); i++) {
            for (int hour = 0; hour < 50; hour++) {
                RandomGenerator.isRaining();
                this.vehicle.get(i).moveForAnHour();
            }
        }
    }

    public void printResults(){

        for (int i = 0 ; i < vehicle.size();i++){
            System.out.println(String.format("%s travelled : %s km",
                    vehicle.get(i).getName(),
                    vehicle.get(i).getDistanceTraveled()));

        }
    }







}
