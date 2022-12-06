package com.example.temperature_calculator;

public class Calculations {

    protected float convertCelciusToFahrenheit(Float value) {
        Float ans = (value * 9/5) + 32;
        return ans;
    }

    protected float convertFahrenheitToCelcius(Float value) {
        Float ans = (value - 32) * 5/9;
        return ans;
    }

}
