
import java.util.ArrayList;
import java.util.List;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Gui extends Application {
    Stage window;
    TableView<Car> table;


    public static void main(String[] args) {

        launch(args);
        // write your code here

    }

    public ObservableList<Car> getCrs(Race race){
        List<Car> cars = race.getCars();
        List<Motorcycle> motorcycles = race.getMotors();
        List<Truck> trucks = race.getTrucks();
        ObservableList<Car> results = FXCollections.observableArrayList();

        for (int i = 0 ; i < cars.size();i++){
        results.add(cars.get(i));

        }

        return results;
    }




    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Car race");

        Button startNewRace = new Button("Start new race");
        // startNewRace button is going to set isCarSelected variable with .isSelected()
        CheckBox carSelect = new CheckBox("Cars");
        CheckBox motoSelect = new CheckBox("Motorcycles");
        CheckBox truckSelect = new CheckBox("Trucks");
        carSelect.setSelected(true);
        motoSelect.setSelected(true);
        truckSelect.setSelected(true);



        VBox leftMenu = new VBox(10);
        leftMenu.setPadding(new Insets(20,20,20,20));
        leftMenu.getChildren().addAll(startNewRace,carSelect,motoSelect,truckSelect);


        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(leftMenu);
        //Name column
        TableColumn<Car, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price column
        TableColumn<Car, Integer> priceColumn = new TableColumn<>("Distance");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("distanceTraveled"));



        table = new TableView<>();


        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        borderPane.setCenter(vBox);


        startNewRace.setOnAction(event -> {
            Race race = new Race();
            race.setNumberOfVehicles(10);
            race.createVehicles();
            Car.setSpeedLimit(70);
            race.simulateRace();
            race.printResults();
            table.setItems(getCrs(race));
            table.getColumns().addAll(nameColumn, priceColumn);



        });


        //Add everything to grid


        Scene scene = new Scene(borderPane, 700, 700);
        window.setScene(scene);
        window.show();
    }
}
