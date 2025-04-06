# Object-Oriented Architecture with Design Patterns

## Overview

This project demonstrates a clean, pattern-driven object-oriented architecture. It focuses on principles like abstraction, encapsulation, and loose coupling — not domain-specific logic. While the example simulates a weather station, the core of this project is its modular and maintainable design.

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
src/
│
├── observer/         → Observer pattern: Observer, Subject
├── sensor/           → Sensors (including adapter) + Factory
├── ui/               → Console/Swing/JavaFX UIs + UI Factory
├── util/             → Measurement units, enums for clean type systems
├── ws/               → WeatherStation (core logic and orchestration)

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