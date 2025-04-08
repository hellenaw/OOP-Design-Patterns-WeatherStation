# Milestone 7 – Adapter & Factory Patterns

## Overview

This milestone extends the Weather Station system with support for a new third-party humidity sensor using the **Adapter Design Pattern**. It also expands the **Factory Pattern** to create the new sensor dynamically, keeping the system modular and open for future extension.

## Implemented Patterns

- **Adapter Pattern**
  - Introduced `HumiditySensor`, which wraps the third-party `HumidityReader` and adapts it to the app’s `Sensor` interface.
  - This enables integration of external components without modifying existing logic.

- **Factory Pattern (Extended)**
  - `SensorFactory` now supports dynamic creation of humidity sensors alongside temperature and pressure sensors.

## Design Principles Applied

- **Program to Interface**  
  All sensors implement the `Sensor` interface, allowing the WeatherStation to remain decoupled from specific sensor implementations.

- **Open/Closed Principle**  
  Existing classes were not modified to support the new sensor type. Instead, behavior was extended via polymorphism and factory abstraction.

## Additional Improvements

- The `MeasurementUnit` enum was extended to support humidity.
- `SensorType` and `TextUI` were also updated to handle and display humidity data.
- The entire app remained fully functional and extensible with no need to modify any core UI logic.

## Folder Structure
milestone-6b-adapter-pattern/
│
├── observer/
│   ├── Observer.java
│   └── Subject.java
│
├── sensor/
│   ├── Sensor.java
│   ├── TemperatureSensor.java
│   ├── PressureSensor.java
│   ├── HumiditySensor.java       ← Adapter implementation
│   └── SensorFactory.java        ← Factory updated for humidity
│
├── ui/
│   ├── TextUI.java               ← Now also displays humidity
│   ├── SwingUI.java
│   ├── JavaFXUI.java
│   ├── StatisticsDisplay.java
│   ├── ForecastDisplay.java
│   └── UIFactory.java
│
├── util/
│   ├── MeasurementUnit.java      ← Added HUMIDITY
│   ├── SensorType.java           ← Added HUMIDITY
│   └── UIType.java
│
├── ws/
│   ├── WeatherStation.java
│   └── WeatherStationRunner.java
│
└── README.md