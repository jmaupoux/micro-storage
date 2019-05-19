package micro.storage;

import io.micronaut.test.annotation.MicronautTest;
import micro.storage.client.StorageClient;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class StorageControllerTest {

    @Inject
    private StorageClient storageClient;

    @Test
    public void testStore() {
        String key = storageClient.store("hello !");
        assertNotNull(key);
        assertTrue(key.matches("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}"));
    }

    @Test
    public void testRetrieve() {
        String content = "hello !";

        String key = storageClient.store(content);
        String content2 = storageClient.retrieve(key);

        assertEquals(content, content2);
    }

}
