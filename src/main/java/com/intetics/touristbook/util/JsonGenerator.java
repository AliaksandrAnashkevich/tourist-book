package com.intetics.touristbook.util;

import com.intetics.touristbook.exception.LocationNotFoundException;
import com.intetics.touristbook.service.dto.PostDto;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class JsonGenerator {

    private static final String URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    private static final String API = "&APPID=047b7a0cf276f7f863a9ae3b199b657d";
    private static volatile JsonGenerator instance;

    public static JsonGenerator getInstance() {
        JsonGenerator localInstance = instance;
        if (localInstance == null) {
            synchronized (JsonGenerator.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new JsonGenerator();
                }
            }
        }
        return localInstance;
    }

    public PostDto getWeather(PostDto post) {
        try {
            JSONObject json=readJsonFromUrl(post.getLocation());
            post.setWeather(json
                    .getJSONArray("weather")
                    .getJSONObject(0)
                    .get("description")
                    .toString());
            post.setTemperature(BigDecimal.valueOf(Double
                                                    .parseDouble(json.getJSONObject("main")
                                                    .get("temp")
                                                    .toString())));
        } catch (Exception e) {
            throw new LocationNotFoundException(ConstantExceptionMessage.locationNotFoundExistsMessageFirstPart
                    +post.getLocation()
                    +ConstantExceptionMessage.locationNotFoundExistsMessageSecondPart);
        }
        return post;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private JSONObject readJsonFromUrl(String location) throws IOException, JSONException {
        URL url = new URL(apiGenerator(location));
        try (InputStream is = url.openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);

            return new JSONObject(jsonText);
        }
    }

    private String apiGenerator(String location) {
        return URL + location + API;
    }

}
