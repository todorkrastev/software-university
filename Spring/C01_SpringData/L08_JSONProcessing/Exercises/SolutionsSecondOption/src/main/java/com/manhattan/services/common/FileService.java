package com.manhattan.services.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileService {
    <T> T[] readFile(String filePath, Class<?> clazz) throws IOException;
//    <T> void writeToFile(String filePath, Iterable<T> records) throws IOException;
    <T> void writeToFile(String filePath, T record) throws IOException;
}
