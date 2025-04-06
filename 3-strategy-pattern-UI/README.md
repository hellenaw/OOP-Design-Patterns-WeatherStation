# Milestone 3: Multi-UI Weather Display with Interface Abstraction

## What Was Implemented

In this milestone, the Weather Station application was extended to support **multiple user interfaces (UIs)** using JavaFX, Swing, and a simple terminal-based text UI. I also introduced an interface-based design to separate display logic from core temperature reading logic.

## Changes Made

### 1. Created a `WeatherDisplay` Interface
- Defines a single method: `updateTemperature(TemperatureUnit unit, double value)`
- Allows the WeatherStation to update the UI without knowing how the UI is implemented

### 2. Added Multiple UI Implementations
#### JavaFXUI
- A modern graphical interface using JavaFX.
- Displays Kelvin and Celsius values using large, styled labels.
- UI updates are safely performed on the JavaFX Application Thread using `Platform.runLater()`.

#### SwingUI
- Uses Java's Swing library with a `JFrame` and dynamic layout.
- Displays temperature in both units with large fonts and centered labels.
- Maps each `TemperatureUnit` to a specific label for easy updates.

#### TextUI
- A simple command-line interface.
- Displays all temperature readings in a single line.
- Executes on the main thread without a separate GUI framework.

### 3. Refactored `WeatherStation`
- Modified to accept a `WeatherDisplay` object as a dependency.
- Uses the display interface to push updates after each sensor reading.
- Applies the **Strategy Pattern** for UI behavior.

### 4. Created a `Main` Launcher
- Asks the user to choose a UI at runtime (1 = Swing, 2 = JavaFX, 3 = Text).
- Starts the corresponding interface and links it to the WeatherStation.

### 5. JAR File Generation (Optional)
- Compiled versions may be included as `.jar` files in a `jars/` folder.
- Each UI can be launched from the terminal by running the `Main` class.

## Why This Matters

- **Separation of Concerns**: The UI logic is fully separated from the core temperature reading logic.
- **Scalability**: New UI types (e.g., web, mobile) can be added without modifying existing logic.
- **Strategy Pattern**: The `WeatherDisplay` interface allows the WeatherStation to delegate display updates, following object-oriented design best practices.
- **Modularity**: Individual components like UIs, sensor logic, and the main loop are cleanly isolated for testing and reuse.

## How to Run

See the [main project README](../README.md) for compile and run instructions.  
At runtime, the program will prompt you to select the interface you'd like to use:
Select UI:
	1.	Swing UI
	2.	JavaFX UI
	3.	Text UI
Enter choice: