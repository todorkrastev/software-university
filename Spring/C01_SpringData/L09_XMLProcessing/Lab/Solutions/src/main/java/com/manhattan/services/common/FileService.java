package com.manhattan.services.common;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface FileService {
    <T> T[] readJSONFile(String filePath, Class<?> clazz) throws IOException;

    <T> void writeToJSONFile(String filePath, T record) throws IOException;

    <T> T readXMLFile(String filePath, Class<?> clazz) throws IOException, JAXBException;

    <T> void writeToXMLFile(String filePath, T record) throws IOException, JAXBException;
}
