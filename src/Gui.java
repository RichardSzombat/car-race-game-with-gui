import javafx.application.Application;
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

        TextField numberOfVehicles = new TextField();
        numberOfVehicles.setPromptText("Enter the number of vehicles (int)");


        VBox leftMenu = new VBox(10);
        leftMenu.setPadding(new Insets(20,20,20,20));
        leftMenu.getChildren().addAll(startNewRace,carSelect,motoSelect,truckSelect,numberOfVehicles);


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

            if (carSelect.isSelected() || motoSelect.isSelected() ||truckSelect.isSelected() ) {
                if (validateInput(numberOfVehicles)){
                    race.setNumberOfVehicles(Integer.parseInt(numberOfVehicles.getText()));
                    race.createVehicles(carSelect.isSelected(),motoSelect.isSelected(),truckSelect.isSelected());
                    Car.setSpeedLimit(70);
                    race.simulateRace();
                    race.printResults();
                    table.setItems(race.getVehicles());
                }else{
                    AlertBox.display("Invalid input","Enter an integer between 1 - 99");
                    numberOfVehicles.clear();
                }
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

    public boolean validateInput(TextField input){
        int number ;
        try{
            number = Integer.parseInt(input.getText());
                if (number < 0 || number >99){
                    return false;
                }
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
