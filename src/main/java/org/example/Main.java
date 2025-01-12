package org.example;

import okhttp3.Request;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        WeatherService weatherService = new WeatherService();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название города: ");
        String city = scanner.nextLine();

        try {
            WeatherResponse weather = weatherService.getWeather(city);
            System.out.printf("Температура: %.1f°C", weather.getCurrentWeather().getTemperatureCelsius());
            System.out.println();
            System.out.println("Облачность: " + weather.getCurrentWeather().getConditionText());
        } catch (IOException e) {
            System.err.println("Ошибка получения данных: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

