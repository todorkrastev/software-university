package softuni.exam.instagraphlite.util.impl;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.util.FileService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class FileServiceImpl implements FileService {
    private final Gson gson;

    public FileServiceImpl(Gson gson) {
        this.gson = gson;
    }

    @Override
    public String readString(String fileName) throws IOException {
        return Files.readString(Path.of(fileName));
    }

    @Override
    public <T> T readJsonFile(String filePath, Class<T> clazz) throws IOException {
        try (JsonReader jsonReader =
                     new JsonReader(new BufferedReader(new InputStreamReader(new FileInputStream(filePath))))) {
            return gson.fromJson(jsonReader, clazz);
        }
    }

    @Override
    public <T> void writeToJsonFile(String filePath, T record) throws IOException {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath))) {
            String result = gson.toJson(record);
            writer.write(result);
            writer.flush();
        }
    }

    @Override
    public <T> T readXmlFile(String filePath, Class<T> clazz) throws IOException, JAXBException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (T) unmarshaller.unmarshal(bfr);
        }
    }

    @Override
    public <T> void writeToXmlFile(String filePath, T record) throws IOException, JAXBException {
        try (FileOutputStream stream = new FileOutputStream(filePath)) {
            JAXBContext jaxbContext = JAXBContext.newInstance(record.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(record, stream);
            stream.flush();
        }
    }
}
