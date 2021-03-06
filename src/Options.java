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
        race.getStyleClass().add("vbox");
        race.setAlignment(Pos.TOP_CENTER);
        race.setPadding(new Insets(10,10,10,20));
        Label raceLabel = new Label();
        raceLabel.setText("Race");


        //Race sliders with labels
        //Raining
        Label isRaining = new Label();
        isRaining.setText("Set the chance of rain");
        Slider chanceOfRain = new Slider();
        Label chanceOfRainLabel= new Label(Integer.toString(Race.chanceOfRain));
        setSlider(chanceOfRain,chanceOfRainLabel,Race.chanceOfRain,0,100);
        //Racing hours
        Label racingHours = new Label("Set racing hours ");
        Slider hours = new Slider();
        Label hoursLabel= new Label(Integer.toString(Race.racingHours));
        setSlider(hours,hoursLabel,Race.racingHours,1,100);


        race.getChildren().addAll(raceLabel,isRaining,chanceOfRain,chanceOfRainLabel,racingHours,hours,hoursLabel);
        raceLabel.setAlignment(Pos.CENTER);


        //TODO cleanCode refactor

        //Car pane
        VBox car = new VBox(10);
        car.getStyleClass().add("vbox");
        car.setAlignment(Pos.TOP_CENTER);
        car.setPadding(new Insets(10,10,10,20));
        Label carLabel = new Label();
        carLabel.setText("Car");


        //Car normal speed
        Label setCarNormalSpeed = new Label("Set normal speed \n between ");
        ChoiceBox<Integer> carMinSpeed = new ChoiceBox<>();
        ChoiceBox<Integer> carMaxSpeed = new ChoiceBox<>();
        for (int i = 0 ; i <= 200; i+=10){
            carMinSpeed.getItems().add(i);
            carMaxSpeed.getItems().add(i);
        }
        carMinSpeed.setValue(Car.minSpeed);
        carMaxSpeed.setValue(Car.maxSpeed);

        //Car limit chance
        Label setCarLimit = new Label("Chance to limit speed");
        Slider limitChance = new Slider();
        Label limitChanceLabel = new Label(Integer.toString(Car.carLimitChance));
        setSlider(limitChance,limitChanceLabel,Car.carLimitChance,0,100);

        //Car limited speed
        Label carLimitedSpeed = new Label("Limited car speed");
        Slider limitedSpeed = new Slider();
        Label limitedSpeedLabel = new Label(Integer.toString(Car.getSpeedLimit()));
        setSlider(limitedSpeed,limitedSpeedLabel,Car.getSpeedLimit(),0,79);

        car.getChildren().addAll(carLabel,setCarNormalSpeed,carMinSpeed,carMaxSpeed,setCarLimit,limitChance,limitChanceLabel,carLimitedSpeed,
                                limitedSpeed,limitedSpeedLabel);

        //Motorcycle pane
        VBox motorcycle = new VBox(10);
        motorcycle.getStyleClass().add("vbox");
        motorcycle.setAlignment(Pos.TOP_CENTER);
        motorcycle.setPadding(new Insets(10,10,10,20));
        Label motorcycleLabel = new Label();
        motorcycleLabel.setText("Motorcycle");

        //Motorcycle normal speed
        Label setMotoNormalSpeed = new Label("Set normal speed");
        Slider motoNormalSpeed = new Slider();
        Label motoNormalSpeedLabel = new Label(Integer.toString(Motorcycle.normalSpeed));
        setSlider(motoNormalSpeed,motoNormalSpeedLabel,Motorcycle.normalSpeed,0,100);

        //Motorcycle custom name
        Label setCustomMotoName = new Label("Enter custom name : ");
        TextField customName = new TextField(Motorcycle.customName);

        motorcycle.getChildren().addAll(motorcycleLabel,setCustomMotoName,customName,setMotoNormalSpeed,
                                        motoNormalSpeed,motoNormalSpeedLabel);

        //Truck pane
        VBox truck = new VBox(10);
        truck.getStyleClass().add("vbox");
        truck.setAlignment(Pos.TOP_CENTER);
        truck.setPadding(new Insets(10,10,10,20));
        Label truckLabel = new Label();
        truckLabel.setText("Truck");

        //Truck normal speed
        Label setTruckNormalSpeed = new Label("Set normal speed");
        Slider truckNormalSpeed = new Slider();
        Label truckNormalSpeedLabel = new Label(Integer.toString(Truck.normalSpeed));
        setSlider(truckNormalSpeed,truckNormalSpeedLabel,Truck.normalSpeed,0,100);

        //Truck breakdown chance
        Label setTruckBreakdownChance = new Label("Breakdown chance");
        Slider truckBreakdown = new Slider();
        Label truckBreakdownLabel = new Label(Integer.toString(Truck.breakdownChance));
        setSlider(truckBreakdown,truckBreakdownLabel,Truck.breakdownChance,0,100);

        //Truck breakdown hours
        Label setBreakdownHours = new Label("Breakdown in hours");
        ChoiceBox<Integer> breakdownHours = new ChoiceBox<>();
        for (int i = 1; i <=10;i++){
            breakdownHours.getItems().add(i);
        }
        breakdownHours.setValue(Truck.breakdownHours);

        truck.getChildren().addAll(truckLabel,setTruckNormalSpeed,truckNormalSpeed,truckNormalSpeedLabel,
                                            setTruckBreakdownChance,truckBreakdown,truckBreakdownLabel,
                                            setBreakdownHours,breakdownHours);

        //Bottom menu
        HBox bottomMenu = new HBox(10);
        bottomMenu.setAlignment(Pos.CENTER);
        bottomMenu.setMinHeight(70);
        Button saveButton = new Button("Save");

        saveButton.setOnAction(event -> {
            if (customName.getText().isEmpty()){
                AlertBox.display("Invalid input","Custom name cannot be empty","OK");
            }else if ((carMaxSpeed.getValue()-carMinSpeed.getValue())<0 || carMaxSpeed.getValue()==0){
                AlertBox.display("Invalid range","Car normal speed must in positive range","OK");
            }else if ((carMinSpeed.getValue() < Integer.parseInt(limitedSpeedLabel.getText()))){
                AlertBox.display("Invalid limited speed","Limited speed cannot exceed minimum speed","OK");
            } else {
                Race.chanceOfRain = Integer.parseInt(chanceOfRainLabel.getText());
                Race.racingHours = Integer.parseInt(hoursLabel.getText());
                Car.carLimitChance = Integer.parseInt(limitChanceLabel.getText());
                Car.setSpeedLimit(Integer.parseInt(limitedSpeedLabel.getText()));
                Car.minSpeed = carMinSpeed.getValue();
                Car.maxSpeed = carMaxSpeed.getValue();
                Motorcycle.normalSpeed = Integer.parseInt(motoNormalSpeedLabel.getText());
                Motorcycle.customName = customName.getText();
                Truck.normalSpeed = Integer.parseInt(truckNormalSpeedLabel.getText());
                Truck.breakdownChance = Integer.parseInt(truckBreakdownLabel.getText());
                Truck.breakdownHours = breakdownHours.getValue();
                AlertBox.display("Saved","Changes have been saved","OK");

            }
        });

        Button cancel = new Button("Cancel");
        cancel.setOnAction(event -> window.close());

        bottomMenu.getChildren().addAll(saveButton,cancel);

        content.getChildren().addAll(race,car,motorcycle,truck,bottomMenu);
        borderPane.setCenter(content);
        borderPane.setBottom(bottomMenu);
        Scene scene = new Scene(borderPane,1000,400);
        scene.getStylesheets().add("options.css");
        window.setMinHeight(420);
        window.setMaxHeight(450);
        window.setScene(scene);
        window.show();

    }
}
