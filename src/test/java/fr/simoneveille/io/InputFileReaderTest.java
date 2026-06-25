package fr.simoneveille.io;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputFileReaderTest {

    @Test
    void shouldReadLinesFromInputFile() throws Exception {
        final String TEST_FILE_LOCATION = "src/test/resources/test-input.txt";
        Path inputPath = Path.of(TEST_FILE_LOCATION);

        InputFileReader reader = new InputFileReader();

        List<String> lines = reader.readLines(inputPath);

        assertEquals(5, lines.size());
        assertEquals("5 5", lines.get(0));
        assertEquals("1 2 N", lines.get(1));
        assertEquals("GAGAGAGAA", lines.get(2));
        assertEquals("3 3 E", lines.get(3));
        assertEquals("AADAADADDA", lines.get(4));
    }
}