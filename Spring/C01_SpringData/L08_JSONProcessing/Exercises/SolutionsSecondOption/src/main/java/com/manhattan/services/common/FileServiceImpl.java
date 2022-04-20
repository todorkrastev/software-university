package com.manhattan.services.common;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class FileServiceImpl implements FileService {
    private final Gson gson;

    public FileServiceImpl(Gson gson) {
        this.gson = gson;
    }

    @Override
    public <T> T[] readFile(String filePath, Class<?> clazz) throws IOException {
        try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filePath)))) {
            return gson.fromJson(jsonReader, clazz);
        }
    }

    @Override
    public <T> void writeToFile(String filePath, T record) throws IOException {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath))) {
            String result = gson.toJson(record);
            writer.write(result);
            writer.flush();
        }
    }
}
