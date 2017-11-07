

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

public class Race extends Application {
    static boolean isRaining ;// 30% chance of rain every hour
    private List<Car> cars = new ArrayList<>();
    private List<Motorcycle> motors = new ArrayList<>();
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






    public static void main(String[] args) {

        launch(args);
        // write your code here

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Car race");

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);


        Text text = new Text("Click the button to start a new race");
        GridPane.setConstraints(text,0,3);

        Button startNewRace = new Button("New Race");
        GridPane.setConstraints(startNewRace, 0, 4);

        TextField numberOfVehicles = new TextField();
        numberOfVehicles.setPromptText("Enter number of vehicles");
        GridPane.setConstraints(numberOfVehicles,0,5);

        Text cars = new Text();
        GridPane.setConstraints(cars,0,7);

        Text trucks = new Text();
        GridPane.setConstraints(trucks,1,7);

        Text motorcycles = new Text();
        GridPane.setConstraints(motorcycles,2,7);

        startNewRace.setOnAction(event -> {
            Race race = new Race();
            race.setNumberOfVehicles(Integer.parseInt((numberOfVehicles.getText())));
            race.createVehicles();
            Car.setSpeedLimit(70);
            race.simulateRace();
            race.printResults();
            cars.setText(Race.carResults);
            trucks.setText(Race.truckResults);
            motorcycles.setText(Race.motorcycleResults);
        });


        //Add everything to grid
        grid.getChildren().addAll(startNewRace,text,cars,trucks,motorcycles,numberOfVehicles);

        Scene scene = new Scene(grid, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
