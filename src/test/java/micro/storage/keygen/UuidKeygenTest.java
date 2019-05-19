package micro.storage.keygen;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UuidKeygenTest {

    private Keygen keygen = new UuidKeygen();

    @Test
    void generate() {
        String key = keygen.generate();

        assertEquals(36, key.length());
        assertNotNull(UUID.fromString(key));
    }
}