package org.example.parser;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class FileParser implements Parser{
    public List<String> fromFileName(String fileName) throws IOException, URISyntaxException {
        return getLines(getFileFromResource(fileName));
    }


    private File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }

    }

    private List<String> getLines(File file) throws IOException {

        List<String> lines;
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

    }
}
