

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

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> cars = new ArrayList<>();

    public List<Motorcycle> getMotors() {
        return motors;
    }

    private List<Motorcycle> motors = new ArrayList<>();

    public List<Truck> getTrucks() {
        return trucks;
    }

    private List<Truck> trucks = new ArrayList<>();
    private Car car;
    private Motorcycle moto;
    private Truck truck;
    static String carResults = "";
    static String truckResults= "";
    static String motorcycleResults="";
    private int numberOfVehicles = 10;

    public int getNumberOfVehicles() {
        return this.numberOfVehicles;
    }

    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }







    // creates 10 cars, 10 trucks and 10 motorcycles
    public void createVehicles(){
        createCars();
        createMotos();
        createTrucks();
    }

    public void createCars(){
        for (int i = 0; i <numberOfVehicles ; i++){
            car = new Car();
            cars.add(car);
        }
    }
    public void createMotos(){
        for (int i = 0; i <numberOfVehicles ; i++){
            moto = new Motorcycle();
            motors.add(moto);
        }
    }
    public void createTrucks(){
        for (int i = 0; i <numberOfVehicles ; i++){
            truck = new Truck();
            trucks.add(truck);
        }
    }


    //simulates the race by calling moveForAnHour() on every vehicle 50 times and setting whether its raining.
    public void simulateRace(){
        Motorcycle.setNameNumber(1);
        for (int i = 0; i < cars.size(); i++) {
            for (int hour = 0; hour < 50; hour++) {
                RandomGenerator.isRaining();
                this.cars.get(i).moveForAnHour();
                this.motors.get(i).moveForAnHour();
                this.trucks.get(i).moveForAnHour();
            }

        }

    }
    // prints each vehicle's name, distance traveled ant type.
    public void printResults(){
        Race.carResults="";
        Race.truckResults="";
        Race.motorcycleResults="";
        for (int i = 0; i < cars.size();i++){
            Race.carResults +=cars.get(i).getName()+" travelled " + cars.get(i).getDistanceTraveled()+" km\n";
            Race.truckResults +=trucks.get(i).getTruckName()+" travelled " + trucks.get(i).getDistanceTraveled()+" km\n";
            Race.motorcycleResults +=motors.get(i).getName()+" travelled " + motors.get(i).getDistanceTraveled()+" km\n";
        }
        


        for (int i = 0 ; i < cars.size();i++){
            System.out.println(String.format("%s travelled : %s km with %s breakdowns",
                    cars.get(i).getName(),
                    cars.get(i).getDistanceTraveled(),
                    cars.get(i).getCarBreakCounter()));
            System.out.println(String.format("%s travelled : %s km with %s hours of rain",
                    motors.get(i).getName(),
                    motors.get(i).getDistanceTraveled(),
                    motors.get(i).getRainCounter()));
            System.out.println(String.format("%s travveled : %s km and broke down %s times",
                    trucks.get(i).getTruckName(),
                    trucks.get(i).getDistanceTraveled(),
                    trucks.get(i).getBreakdownCounter()));
        }
    }

    public String printCarScores(){
        StringBuilder carsScore = null;
        for (int i = 0; i < cars.size();i++){
            carsScore.append(String.format("%s travelled : %s km with %s breakdowns\n",
                    cars.get(i).getName(),
                    cars.get(i).getDistanceTraveled(),
                    cars.get(i).getCarBreakCounter()));

        }return carsScore.toString();
    }






}
