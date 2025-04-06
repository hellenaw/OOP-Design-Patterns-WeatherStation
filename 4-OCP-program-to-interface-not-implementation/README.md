# Milestone 4: Open/Closed Design with Extendable Sensor Architecture

## What Was Implemented

This milestone focuses on applying key object-oriented principles — particularly the **Open/Closed Principle** (OCP) and **Interface Segregation** — to transform the Weather Station into a flexible, multi-sensor system. The design now supports multiple types of measurements (temperature, pressure) with minimal changes to the core logic.

## Core Design Improvements

### Open/Closed Principle (OCP)
- The system is now **open for extension**, but **closed for modification**.
- New sensor types and units (e.g., atmospheric pressure) can be added without altering existing WeatherStation logic.
- Achieved by using generalized interfaces and maps to handle sensors and measurement units dynamically.

### Interface Segregation & Strategy Pattern
- Introduced a new interface `WeatherStationUI` which allows any UI implementation to define how it receives updates.
- All UIs (Swing, JavaFX, Text) now implement this unified interface and receive all measurement data as a single `EnumMap<MeasurementUnit, Double>`.
- This follows the **Strategy Pattern**, allowing interchangeable UI "strategies" at runtime.

### Encapsulation and Reusability
- Unified all unit conversion logic into the new `MeasurementUnit` enum:
  - Supports both **temperature** and **pressure** units.
  - Uses conversion factors (`cf1`, `cf2`) to simplify and isolate logic.
- Sensors implement a generic `Sensor` interface, encapsulating their own behavior and trends internally.
### Programming to an Interface
- Both `Sensor` and `WeatherStationUI` are used via their interfaces rather than concrete classes.
- This allows `WeatherStation` to interact with any sensor or UI implementation without knowing the details.
- Promotes flexibility, testability, and decouples logic from specific implementations.

## New Architectural Components

### 1. `Sensor` Interface
- Defines a single `read()` method.
- Implemented by `TemperatureSensor` and newly added `PressureSensor`.

### 2. `SensorType` Enum
- Identifies sensor categories: `TEMPERATURE`, `PRESSURE`.
- Used to map sensors and determine which units to convert.

### 3. `MeasurementUnit` Enum
- Replaces `TemperatureUnit`.
- Stores the unit’s category, conversion logic, and formatting.
- Easily extensible to include more measurement types (e.g., humidity, wind).

### 4. Unified Sensor Reading in `WeatherStation`
- Stores and updates readings dynamically via `EnumMap<SensorType, Sensor>` and `EnumMap<MeasurementUnit, Double>`.
- Decouples data acquisition from display logic completely.

---

## Why This Matters

This milestone transforms the application into a **scalable**, **extensible**, and **modular** system. The architecture is no longer bound to temperature-only logic. Instead, it's designed for growth, supporting multiple data types, UIs, and formats without violating solid design principles.

Key takeaways for reviewers:
- Strong use of OOP interfaces and abstractions.
- Practical application of **SOLID principles** in Java.
- Demonstrates ability to refactor from hardcoded logic to a generalized, open system.

---

## How to Run

See the [main project README](../README.md) for compile and run instructions.

When running the program, select the UI: