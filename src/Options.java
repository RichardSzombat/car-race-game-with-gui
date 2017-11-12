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
    public static int racingHours = 50;



    public static void setSlider(Slider slider,Label sliderLabel,int sliderValue,int sliderMin, int sliderMax){
        slider.setValue(sliderValue);
        slider.setMin(sliderMin);
        slider.setMax(sliderMax);
        slider.valueProperty().addListener((obs, oldval, newVal) ->
                slider.setValue(newVal.intValue()));
        sliderLabel.textProperty().bindBidirectional(slider.valueProperty(),NumberFormat.getNumberInstance());
    }

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


        //Race sliders with labels
        //Raining
        Label isRaining = new Label();
        isRaining.setText("Set the chance of rain");
        Slider chanceOfRain = new Slider();
        Label chanceOfRainLabel= new Label(Integer.toString(RandomGenerator.chanceOfRain));
        setSlider(chanceOfRain,chanceOfRainLabel,RandomGenerator.chanceOfRain,0,100);
        //Racing hours
        Label racingHours = new Label("Set racing hours ");
        Slider hours = new Slider();
        Label hoursLabel= new Label(Integer.toString(Options.racingHours));
        setSlider(hours,hoursLabel,Options.racingHours,1,100);




        race.getChildren().addAll(raceLabel,isRaining,chanceOfRain,chanceOfRainLabel,racingHours,hours,hoursLabel);
        raceLabel.setAlignment(Pos.CENTER);


        //TODO clean up the code !!
        //TODO static variables in Options instead RandomGenerator
        //Car pane
        VBox car = new VBox(10);
        car.setPadding(new Insets(10,10,10,20));
        car.setPrefWidth(200);
        Label carLabel = new Label();
        carLabel.setText("Car");

        //Car limit chance
        Label setCarLimit = new Label("Chance to limit speed");
        Slider limitChance = new Slider();
        Label limitChanceLabel = new Label(Integer.toString(RandomGenerator.carLimitChance));
        setSlider(limitChance,limitChanceLabel,RandomGenerator.carLimitChance,0,100);


        car.getChildren().addAll(carLabel,setCarLimit,limitChance,limitChanceLabel);

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
            RandomGenerator.chanceOfRain = Integer.parseInt(chanceOfRainLabel.getText());
            Options.racingHours = Integer.parseInt(hoursLabel.getText());
            RandomGenerator.carLimitChance = Integer.parseInt(limitChanceLabel.getText());
        });
        saveButton.setPadding(new Insets(10,10,10,10));
        bottomMenu.getChildren().addAll(saveButton);


        content.getChildren().addAll(race,car,motorcycle,truck,bottomMenu);

        borderPane.setCenter(content);
        borderPane.setBottom(bottomMenu);


        Scene scene = new Scene(borderPane,800,400);
        window.setScene(scene);
        window.show();

    }
}
