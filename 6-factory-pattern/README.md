# Milestone 6a – Factory Pattern

## Overview

This milestone introduces the **Factory Pattern** to decouple object creation from the core logic of the application. It eliminates direct instantiation of sensors and UI elements in favor of centralized factories, improving extensibility and maintainability.

---

## Implemented Design Pattern

### Factory Pattern

- `SensorFactory`: Responsible for creating different types of `Sensor` objects (`TemperatureSensor`, `PressureSensor`) based on the provided `SensorType` enum.
- `UIFactory`: Responsible for creating UI components (`TextUI`, `SwingUI`, `JavaFXUI`, `StatisticsDisplay`, `ForecastDisplay`) based on the `UIType` enum.

This pattern enables scalable and flexible object creation, making the system easier to extend without modifying existing logic.

---

## Object-Oriented Principles Applied

- **Program to Interface, Not Implementation**:  
  All sensors implement the `Sensor` interface, and all UI components implement the `Observer` interface. The factories return instances via these interfaces, supporting loose coupling and easier substitution.

- **Open/Closed Principle**:  
  The system is now open for extension (e.g., adding new sensors or UI types) without modifying existing code, thanks to the use of factories and enums.

---

## Code Highlights

- In `WeatherStationRunner`, all sensors are created using `SensorFactory.createSensor(SensorType)`.
- UI creation is handled by `UIFactory.createUI(UIType, station)`, replacing the previous `switch` or `if` conditions.
- The app now supports adding new sensors or UIs by updating only the factories and enums.

---

## Folder Structure
milestone-6a-factory-pattern/
│
├── observer/
│   ├── Observer.java
│   └── Subject.java
│
├── sensor/
│   ├── Sensor.java
│   ├── TemperatureSensor.java
│   ├── PressureSensor.java
│   └── SensorFactory.java
│
├── ui/
│   ├── TextUI.java
│   ├── SwingUI.java
│   ├── JavaFXUI.java
│   ├── StatisticsDisplay.java
│   ├── ForecastDisplay.java
│   └── UIFactory.java
│
├── util/
│   ├── MeasurementUnit.java
│   ├── SensorType.java
│   └── UIType.java
│
├── ws/
│   ├── WeatherStation.java
│   └── WeatherStationRunner.java
│
└── README.md

---

## Benefits

- Simplified `WeatherStationRunner` logic
- Easier testing and mocking of components
- Greater flexibility to support future growth (e.g., more sensors or UIs)