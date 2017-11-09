
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

import javafx.scene.layout.VBox;

import javafx.stage.Stage;


public class Gui extends Application {
    Stage window;
    TableView<Vehicle> table;

    public static void main(String[] args) {
        launch(args);
    }

    public ObservableList<Vehicle> getVehicle(Race race){
        List<Vehicle> vehicle = race.getVehicle();
        ObservableList<Vehicle> results = FXCollections.observableArrayList();
        for (int i = 0 ; i < vehicle.size();i++){
        results.add(vehicle.get(i));
        }
        return results;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Car race");
        window.setMinWidth(700);
        window.setMaxWidth(800);
        window.setMinHeight(600);
        window.setMaxHeight(800);

        Button startNewRace = new Button("Start new race");
        CheckBox carSelect = new CheckBox("Cars");
        CheckBox motoSelect = new CheckBox("Motorcycles");
        CheckBox truckSelect = new CheckBox("Trucks");
        carSelect.setSelected(true);
        motoSelect.setSelected(true);
        truckSelect.setSelected(true);


        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(40);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(50);
        slider.setMinorTickCount(5);
        slider.setBlockIncrement(10);



        VBox leftMenu = new VBox(10);
        leftMenu.setPadding(new Insets(20,20,20,20));
        leftMenu.getChildren().addAll(startNewRace,carSelect,motoSelect,truckSelect,slider);


        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(leftMenu);

        TableColumn<Vehicle, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));


        TableColumn<Vehicle, Integer> distanceColumn = new TableColumn<>("Distance");
        distanceColumn.setMinWidth(100);
        distanceColumn.setCellValueFactory(new PropertyValueFactory<>("distanceTraveled"));

        table = new TableView<>();
        table.setMinWidth(350);
        table.setMaxWidth(400);
        table.setMinHeight(600);

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox content = new VBox();
        content.getChildren().addAll(table);

        borderPane.setCenter(content);

        startNewRace.setOnAction(event -> {
            Race race = new Race();
            race.setNumberOfVehicles(10);
            if (carSelect.isSelected() || motoSelect.isSelected() ||truckSelect.isSelected() ) {

                race.createVehicles(carSelect.isSelected(),motoSelect.isSelected(),truckSelect.isSelected());
                Car.setSpeedLimit(70);
                race.simulateRace();
                race.printResults();
                table.setItems(getVehicle(race));
            }else {
                AlertBox.display("Nothing selected","Select something");

            }
        });

        table.getColumns().addAll(nameColumn, distanceColumn);
        Scene scene = new Scene(borderPane, 700, 700);
        scene.getStylesheets().add("myStyle.css");
        window.setScene(scene);

        window.show();
    }
}
