package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    @JsonProperty("current")
    private CurrentWeather currentWeather;

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CurrentWeather {
        @JsonProperty("temp_c")
        private float temperatureCelsius;

        @JsonProperty("condition")
        private Condition condition;

        public float getTemperatureCelsius() {
            return temperatureCelsius;
        }

        public String getConditionText() {
            return condition.text;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Condition {
            @JsonProperty("text")
            private String text;
        }
    }

}
