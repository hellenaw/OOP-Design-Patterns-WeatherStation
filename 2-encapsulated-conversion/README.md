# Milestone 2: TemperatureUnit Enum and Cleaner Conversion

## What Was Implemented

In this milestone, I refactored the code to better separate responsibilities and **encapsulate unit conversion logic** using an `enum`. This made the code more flexible, easier to read, and aligned with object-oriented design principles.

## Changes Made

### 1. Introduced `TemperatureUnit` Enum
- Created an `enum` called `TemperatureUnit` with two values:
  - `KELVIN`
  - `CELSIUS`
- Each enum constant has its own conversion factor:
  - `KELVIN = 0`
  - `CELSIUS = -27315`
- Added a `get(int reading)` method that converts raw sensor readings to the correct temperature in double format.

### 2. Updated `WeatherStation` Class
- Removed hardcoded conversion logic from the `run()` method.
- Replaced it with calls to `TemperatureUnit.CELSIUS.get(reading)` and `TemperatureUnit.KELVIN.get(reading)`.
- This improves readability and future extensibility (e.g., adding Fahrenheit later).

### 3. Renamed `TemperatureSensor.reading()` to `read()`
- Clearer method name that reads more like a command.
- Keeps naming consistent and focused.

## Why This Matters

- **Encapsulation:** By moving conversion logic into the enum, we keep related behavior with the data it belongs to.
- **DRY Principle:** Eliminates duplicate conversion math and hardcoded constants.
- **Open/Closed Principle:** The enum can be extended with new units without changing the main logic in `WeatherStation`.
- **Improved Readability:** Cleaner and more intuitive logic in the `run()` loop.

## How to Run

See the [main project README](../README.md) for compile and run instructions.