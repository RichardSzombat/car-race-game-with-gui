import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Options {
    public static void display() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Options");
        window.setMinWidth(250);

        HBox content = new HBox(10);

        //Race pane
        Pane race = new Pane();
        race.setPrefWidth(200);
        Label raceLabel = new Label();
        raceLabel.setText("Race");
        race.getChildren().add(raceLabel);
        raceLabel.setAlignment(Pos.CENTER);

        //Car pane
        Pane car = new Pane();
        car.setPrefWidth(200);
        Label carLabel = new Label();
        carLabel.setText("Car");
        car.getChildren().add(carLabel);

        //Motorcycle pane
        Pane motorcycle = new Pane();
        motorcycle.setPrefWidth(200);
        Label motorcycleLabel = new Label();
        motorcycleLabel.setText("Motorcycle");
        motorcycle.getChildren().add(motorcycleLabel);

        //Truck pane
        Pane truck = new Pane();
        truck.setPrefWidth(200);
        Label truckLabel = new Label();
        truckLabel.setText("Truck");
        truck.getChildren().add(truckLabel);

        content.getChildren().addAll(race,car,motorcycle,truck);



//        Label label = new Label();
//        label.setText(message);
//
//        Button closeButton = new Button("Close the window");
//        closeButton.setOnAction(event -> window.close());

//        HBox layout = new HBox(10);
//        layout.getChildren().addAll(label, closeButton);
//        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(content,800,600);
        window.setScene(scene);
        window.show();

    }
}
