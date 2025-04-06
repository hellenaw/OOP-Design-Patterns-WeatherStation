# Starter Code: Weather Station Project

This folder contains the original starter code provided by the professor for **Activity 1: Enhancing the Weather Station**.

## Overview

The code simulates a simple weather station that prints temperature readings in **Kelvin** once per second. The system is composed of two Java classes:

### 1. TemperatureSensor.java
- Simulates a physical temperature sensor.
- Returns readings in the range 0–65535, representing temperatures in **Kelvin** to the nearest hundredth of a degree.
- Internally, the simulated temperature fluctuates slightly with each reading, trending up or down with some randomness.
- Readings are bounded between 233.15K and 383.15K (i.e., -40°C to 110°C).

### 2. WeatherStation.java
- Creates a sensor and runs it in a separate thread.
- Every second, it fetches a new reading from the sensor.
- Converts the raw integer value to Kelvin and prints it in the format:
- Reading is nnn.nn degrees K
- ## Purpose

This version serves as the **baseline** for all future enhancements and milestones. It helped us understand how to:
- Simulate hardware-like behavior in software.
- Use threads to run time-based tasks.
- Format output using `System.out.printf`.

## How to Run

See the [main project README](../README.md) for instructions on compiling and running the program.