package micro.storage.keygen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HumanFriendlyKeygenTest {

    private Keygen keygen = new HumanFriendlyKeygen();

    @Test
    void generate() {
        String key = keygen.generate();

        assertEquals(8, key.length());
        assertTrue(key.matches("[0-9a-zA-Z]{8}"));
    }
}