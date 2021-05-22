package bg.softuni.java_advanced.streams_files_and_directories.lab;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class E06SortLines {
    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("input.txt"))
                .stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        Files.write(Paths.get("output.txt"), lines, Charset.defaultCharset());
    }
}
