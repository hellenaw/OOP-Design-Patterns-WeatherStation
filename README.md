# Object-Oriented Architecture with Design Patterns

## Overview

This project demonstrates a clean, pattern-driven object-oriented architecture. It focuses on principles like abstraction, encapsulation, and loose coupling — not domain-specific logic. While the example simulates a weather station, the core of this project is its modular and maintainable design.

## How to Use
## 1. Clone the repository
git clone https://github.com/hellenaw/OOP-Design-Patterns-WeatherStation.git

## 2. Navigate to a milestone folder
cd milestone-6-adapter-pattern/src

## 3. Compile and run the program
## Include all .jar files from the lib/ directory in the classpath

- javac -cp ".:../../lib/*" edu/rit/croatia/swen383/g3/ws/WeatherStationRunner.java
- java -cp ".:../../lib/*" edu.rit.croatia.swen383.g3.ws.WeatherStationRunner

- On Windows, replace : with ; in the classpath:
- javac -cp ".;../../lib/*" ...

## Key Concepts

- **Program to Interface**: All sensor and UI components depend on interfaces (`Sensor`, `Observer`) rather than implementations.
- **Encapsulation**: Sensors, UI logic, and data handling are isolated into focused, reusable components.
- **DRY Principle**: Reused shared logic through enums, factories, and consistent Observer wiring.
- **Separation of Concerns**: Sensor input, unit conversion, UI display, and orchestration are cleanly separated.

## Design Patterns Used

| Pattern      | Applied In                          | Purpose                                                                 |
|--------------|--------------------------------------|-------------------------------------------------------------------------|
| **Observer** | `Subject`, all UI classes            | Decouples the data source from multiple reactive observers              |
| **Factory**  | `SensorFactory`, `UIFactory`         | Centralizes and abstracts object creation based on enum types           |
| **Adapter**  | `HumiditySensor`                     | Wraps a third-party `HumidityReader` to match the internal `Sensor` API |

## Project Structure
<pre>
```text
├── milestone-1/
│   └── src/
├── milestone-2/
│   └── src/
├── milestone-3/
│   └── src/
├── milestone-4/
│   └── src/
├── milestone-5/
│   └── src/
├── milestone-6-factory-pattern/
│   └── src/
├── milestone-7-adapter-pattern/
│   └── src/
├── lib/                         # Contains required .jar files for JavaFX and Swing
└── README.md                    # You are here
```
</pre>

Each milestone builds incrementally on the previous one, with Milestone 7 being the final version.

## Highlights

- All UI implementations (text, Swing, JavaFX) plug into the same subject using the Observer pattern.
- Sensors are created dynamically using `SensorFactory`, supporting seamless extensibility.
- `HumiditySensor` wraps a third-party class (`HumidityReader`) using the Adapter pattern to maintain interface consistency.
- Sensor readings are unified across various measurement units using an `enum`-based conversion system.
- `UIFactory` cleanly wires up different frontends using the Factory pattern and enum-based configuration.

## Why This Matters

This project isn't about weather — it's about software design. It demonstrates:

- Solid understanding of OOP fundamentals
- Practical use of **classic design patterns**
- Ability to integrate third-party code without violating architecture
- Writing **extensible, maintainable, testable** systems

## Author

Developed for academic purposes and refined as a showcase of design and architectural skills in Java.