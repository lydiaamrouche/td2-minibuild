import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.provider.CsvSource;
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
    @ParameterizedTest
    @CsvSource(value = {
            "''",                         // chaîne vide
            "org.acme:lib-a",             // version manquante
            ":lib-a:1.0.0",               // groupe vide
            "org.acme::1.0.0",            // artefact vide
            "org.acme:lib-a:",            // version vide
            "org.acme:lib-a:1.0.0:extra"  // partie en trop
    })
    void rejetteLesCoordonneesMalFormees(String coordonnee) {
        assertThrows(IllegalArgumentException.class, () -> Gav.parse(coordonnee));
    }

    @org.junit.jupiter.api.Test
    void rejetteUneCoordonneeNulle() {
        assertThrows(IllegalArgumentException.class, () -> Gav.parse(null));
    }
}