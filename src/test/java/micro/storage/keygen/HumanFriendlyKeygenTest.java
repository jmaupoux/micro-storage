package micro.storage.keygen;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
class HumanFriendlyKeygenTest {

    @Inject
    private Keygen keygen;

    @Test
    void generate() {
    }
}