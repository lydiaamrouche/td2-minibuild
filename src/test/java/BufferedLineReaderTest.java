import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BufferedLineReaderTest {

    @Test
    void litLesLignesPuisSignaleLaFin() throws IOException {
        BufferedReader source = new BufferedReader(
                new StringReader("premiere ligne\nseconde ligne")
        );
        ILineReader reader = new BufferedLineReader(source);

        assertEquals("premiere ligne", reader.readLine());
        assertEquals("seconde ligne", reader.readLine());
        assertNull(reader.readLine());
    }
}