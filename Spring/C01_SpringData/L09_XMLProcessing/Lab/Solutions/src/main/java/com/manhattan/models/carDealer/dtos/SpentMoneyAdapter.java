package com.manhattan.models.carDealer.dtos;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Map;

public class SpentMoneyAdapter extends TypeAdapter<Double> {

    @Override
    public void write(JsonWriter out, Double value) throws IOException {
        out.value(String.format("%.2f",value));
    }

    @Override
    public Double read(JsonReader in) throws IOException {
        return null;
    }
}
