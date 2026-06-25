package fr.simoneveille.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class InputFileReader {

    public List<String> readLines(Path input) throws IOException {
        return Files.readAllLines(input);
    }
}
