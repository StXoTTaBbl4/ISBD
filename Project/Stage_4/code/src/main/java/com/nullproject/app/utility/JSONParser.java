package com.nullproject.app.utility;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;

public class JSONParser {
//    public static String toJSON(){
//
//    }

    public static JsonObject fromJSON(HttpServletRequest req) throws IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
            buffer.append(System.lineSeparator());
        }

        return JsonParser.parseString(buffer.toString()).getAsJsonObject();

    }
}
