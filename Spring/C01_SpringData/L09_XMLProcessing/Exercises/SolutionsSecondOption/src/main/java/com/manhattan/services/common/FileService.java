package com.manhattan.services.common;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface FileService {
    <T> T[] readJsonFile(String filePath, Class<T> clazz) throws IOException;

    <T> void writeToJsonFile(String filePath, T record) throws IOException;

    <T> T readXmlFile(String filePath, Class<T> clazz) throws IOException, JAXBException;

    <T> void writeToXmlFile(String filePath, T record) throws IOException, JAXBException;
}
