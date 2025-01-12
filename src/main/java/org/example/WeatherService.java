package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherService {
    private final OkHttpClient client;
    private final String apiKey = "cd166ebc0da64dabb18133306251201";

    public WeatherService() {
        this.client = new OkHttpClient();
    }
    public WeatherResponse getWeather(String city) throws IOException {
        //http://api.weatherapi.com/v1/current.json?key=cd166ebc0da64dabb18133306251201&q=Moscow&aqi=no
        String url = String.format("http://api.weatherapi.com/v1/current.json?key=%s&q=%s&aqi=no", apiKey, city);
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Некорректный код " + response);
            return new ObjectMapper().readValue(response.body().string(), WeatherResponse.class);
        }
    }


}
