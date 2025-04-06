# Milestone 1: Add Celsius Output

## What Was Implemented

In this milestone, I enhanced the original Weather Station code to **print both Kelvin and Celsius** temperature values on each reading.

### Changes Made
- Updated the `WeatherStation.java` class to:
  - Calculate the Celsius value using the formula:  
    ```
    Celsius = Kelvin - 273.15
    ```
  - Format and print both values on the same line:
    ```
    Reading is nnn.nn degrees C and mmm.mm degrees K
    ```

### Key Modifications
- Introduced new variables for `kelvin` and `celsius` readings.
- Defined a `KTOC` constant representing the conversion offset in hundredths of a degree.
- Modified the `System.out.printf` statement to include both temperature formats.

### Why This Matters
- It improves user readability and functionality by showing a more familiar temperature unit (Celsius).
- It shows an understanding of basic unit conversions and string formatting in Java.

## How to Run

See the [main project README](../README.md) for compile and run instructions.