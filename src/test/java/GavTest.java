import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GavTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/gav.csv", numLinesToSkip = 1)
    void parseExtraitLesTroisParties(
            String coordonnee, String groupe, String artefact, String version) {
        Gav gav = Gav.parse(coordonnee);

        assertEquals(groupe, gav.group());
        assertEquals(artefact, gav.artifact());
        assertEquals(version, gav.version());
    }
}