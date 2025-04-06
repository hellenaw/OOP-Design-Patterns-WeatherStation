# Milestone 5: Observer Pattern for Decoupled UI Updates

## What Was Implemented

This milestone introduces the **Observer design pattern** to fully decouple the WeatherStation from the UI components. Instead of pushing updates directly, the WeatherStation now acts as a **Subject** that notifies all registered **Observers** when new sensor data is available.

This milestone reflects a shift from procedural data flow to a **publish-subscribe architecture**, promoting modularity, testability, and reusability.

---

## Key Design Patterns and Principles Applied

###  Observer Pattern
- `Subject` maintains a list of `Observer` objects and notifies them with `notifyObservers()`.
- The `WeatherStation` class now extends `Subject` and no longer handles UI logic directly.
- All UIs (`SwingUI`, `JavaFXUI`, `TextUI`) and extra displays (`ForecastDisplay`, `StatisticsDisplay`) implement the `Observer` interface and register themselves with the station.
- Each observer independently decides how to react to new data.

###  Programming to an Interface
- The `Observer` interface ensures all display components expose a common `update()` method.
- The `Sensor` interface continues to abstract away sensor implementations (`TemperatureSensor`, `PressureSensor`).

###  Loose Coupling & Reusability
- The `WeatherStation` is now **fully independent** of how data is displayed.
- UIs and data processors can be **added, removed, or modified** without touching WeatherStation logic.

###  Single Responsibility Principle
- Each observer class has a clear, focused role:
  - `JavaFXUI`, `SwingUI`, `TextUI`: display raw data
  - `StatisticsDisplay`: computes and prints simple stats
  - `ForecastDisplay`: shows a basic weather forecast based on rules

###  Package Organization
- Code is now **logically divided** into `observer`, `sensor`, `ui`, `util`, and `ws` packages.
- Each package focuses on a specific concern (e.g., sensors, display, utility enums), improving clarity and maintainability.

---

## Technical Improvements Over Previous Milestone

- **Removed direct UI handling** from `WeatherStation`.
- Added **ForecastDisplay** and **StatisticsDisplay** as new non-UI observers that react to sensor data.
- Shifted from `WeatherStationUI` abstraction to **true observer subscription**.
- Each observer independently pulls the data it needs using `station.getReading(...)`.
- Better **thread safety and encapsulation** — the station only triggers updates, without managing rendering logic.

---

## Why This Matters

This milestone demonstrates a critical leap in architectural thinking:
- You’ve moved from hardcoded, procedural updates to a **flexible, event-driven model**.
- You’ve **decentralized responsibilities**, making each component testable, replaceable, and independently understandable.
- This mirrors how real-world software systems scale (e.g., live dashboards, multi-subscriber services).

If this were a production system, your design would now allow:
- Logging observers
- Networked or remote UIs
- Statistical models reacting in real time
- Selective subscriptions (e.g., only observe pressure)

---

## How to Run

See the [main project README](../README.md) for compile and run instructions.

At runtime, you'll be asked to select a UI:
Select UI:
	1.	Swing UI
	2.	JavaFX UI
	3.	Text UI

Once launched, you’ll see live updates from the following observers:
- A selected UI display
- ForecastDisplay (terminal)
- StatisticsDisplay (terminal)