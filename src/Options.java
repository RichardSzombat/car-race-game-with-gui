import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.text.NumberFormat;

public class Options {

    public static final int CHANCE_OF_RAIN = 30;

    public static void display() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Options");
        window.setMinWidth(250);

        BorderPane borderPane = new BorderPane();


        HBox content = new HBox(10);

        //Race pane
        VBox race = new VBox(10);
        race.setPadding(new Insets(10,10,10,20));
        race.setPrefWidth(200);
        Label raceLabel = new Label();
        raceLabel.setText("Race");
        Label isRaining = new Label();
        isRaining.setText("Set the chance of rain");

        //Slider with labels
        Slider chanceOfRain = new Slider();
        chanceOfRain.setValue(CHANCE_OF_RAIN);
        chanceOfRain.setMin(0);
        chanceOfRain.setMax(100);
        Label chanceOfRainValue = new Label(Integer.toString(CHANCE_OF_RAIN));
        chanceOfRain.valueProperty().addListener((obs, oldval, newVal) ->
                chanceOfRain.setValue(newVal.intValue()));
        chanceOfRainValue.textProperty().bindBidirectional(chanceOfRain.valueProperty(),NumberFormat.getNumberInstance());

        race.getChildren().addAll(raceLabel,isRaining,chanceOfRain,chanceOfRainValue);
        raceLabel.setAlignment(Pos.CENTER);

        //Car pane
        VBox car = new VBox(10);
        car.setPadding(new Insets(10,10,10,20));
        car.setPrefWidth(200);
        Label carLabel = new Label();
        carLabel.setText("Car");
        car.getChildren().add(carLabel);

        //Motorcycle pane
        VBox motorcycle = new VBox(10);
        motorcycle.setPadding(new Insets(10,10,10,20));
        motorcycle.setPrefWidth(200);
        Label motorcycleLabel = new Label();
        motorcycleLabel.setText("Motorcycle");
        motorcycle.getChildren().add(motorcycleLabel);

        //Truck pane
        VBox truck = new VBox(10);
        truck.setPadding(new Insets(10,10,10,20));
        truck.setPrefWidth(200);
        Label truckLabel = new Label();
        truckLabel.setText("Truck");
        truck.getChildren().add(truckLabel);


        //Bottom menu
        HBox bottomMenu = new HBox(10);
        bottomMenu.setAlignment(Pos.CENTER);
        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> {
            RandomGenerator.chanceOfRain = Integer.parseInt(chanceOfRainValue.getText());
        });
        saveButton.setPadding(new Insets(10,10,10,10));
        bottomMenu.getChildren().addAll(saveButton);


        content.getChildren().addAll(race,car,motorcycle,truck,bottomMenu);

        borderPane.setCenter(content);
        borderPane.setBottom(bottomMenu);


        Scene scene = new Scene(borderPane,800,600);
        window.setScene(scene);
        window.show();

    }
}
