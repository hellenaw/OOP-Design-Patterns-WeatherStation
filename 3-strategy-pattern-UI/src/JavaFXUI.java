
/**
 * JavaFXUI is a JavaFX application that displays temperature readings in both
 * Celsius and Kelvin formats. It provides a simple UI with labels to show
 * temperature values and allows updating them dynamically.
 *
 * @author Kristina Marasovic [kristina.marasovic@croatia.rit.edu]
 */
import java.util.EnumMap;
import java.util.Map;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class JavaFXUI extends Application implements WeatherDisplay{
    
    private final Map<TemperatureUnit, Label> labelMap = new EnumMap<>(TemperatureUnit.class);


    /**
     * Starts the JavaFX application and initializes the UI.
     *
     * @param primaryStage the primary stage for this application
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Weather Station");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);

      //create and add ui elements
      int column = 0;
      for (TemperatureUnit unit : TemperatureUnit.values()) {
        VBox temperatureBox = createTemperatureDisplay(unit.name());
        labelMap.put(unit, (Label) temperatureBox.getChildren().get(1)); //stores reference in map
        gridPane.add(temperatureBox,column++,0);
    }

        Scene scene = new Scene(gridPane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

        WeatherStation station = new WeatherStation(this);
        Thread stationThread = new Thread(station);
        stationThread.setDaemon(true); //set as daemon thread so it  stops when the ui closes
        stationThread.start();
    }

    /**
     * Creates a VBox containing a temperature display with a title label and a
     * value label.
     *
     * @param title the title of the temperature display
     * @return a VBox containing the title and value labels
     */
    private VBox createTemperatureDisplay(String title) {
        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-font-size: 36px; -fx-font-weight: bold;");
        titleLabel.setAlignment(Pos.CENTER);

        Label valueLabel = new Label("");
        valueLabel.setStyle("-fx-font-size: 36px;");
        valueLabel.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(10, titleLabel, valueLabel);
        vbox.setAlignment(Pos.CENTER);
        return vbox;
    }

   //
    /**
     * updates the temperatrure label dynamically based on the temperatureunit
     * @param unit the temperatureunit to update
     * @param temperature the temperature value to set
     */
    public void setLabel(TemperatureUnit unit, double temperature) {
        if (labelMap.containsKey(unit)) {
            Platform.runLater(() -> labelMap.get(unit).setText(String.format("%6.2f",temperature)));
        } else {
            System.out.println("ERROR: temperatureUnit not found in map.");
        }
    }
    
    /**
     * The main method launches the JavaFX application. The launch() method
     * blocks the main thread and waits until the application is closed,
     * allowing JavaFX to manage the event loop and UI updates.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void updateTemperature(TemperatureUnit unit, double value) {
        if(labelMap.containsKey(unit)){
            Platform.runLater(() -> labelMap.get(unit).setText(String.format("%6.2f", value)));
        }
    }
}
