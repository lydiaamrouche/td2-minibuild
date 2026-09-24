import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InMemoryStorageTest {
    private IStorage storage;

    @BeforeEach
    void init() {
        storage = new InMemoryStorage();
    }

    @Test
    void getRenvoieUnOptionalVideSiLaCoordonneeEstAbsente() {
        Gav gav = Gav.parse("org.acme:absent:1.0.0");

        assertTrue(storage.get(gav).isEmpty());
    }

    @Test
    void putPermetDeRetrouverUnArtefact() {
        Gav gav = Gav.parse("org.acme:lib-a:1.0.0");
        Artifact artifact = new Artifact(gav, Set.of());

        storage.put(gav, artifact);

        assertSame(artifact, storage.get(gav).orElseThrow());
    }
}