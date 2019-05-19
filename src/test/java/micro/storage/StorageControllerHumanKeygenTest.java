package micro.storage;

import io.micronaut.test.annotation.MicronautTest;
import micro.storage.client.StorageClient;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest(propertySources = "classpath:human.yml")
public class StorageControllerHumanKeygenTest {

    @Inject
    private StorageClient storageClient;

    @Test
    public void testStoreHumanKey() {
        String key = storageClient.store("hello !");
        assertNotNull(key);
        assertTrue(key.matches("[0-9a-zA-Z]{8}"));
    }

    @Test
    public void testRetrieveHumanKey() {
        String content = "hello !";

        String key = storageClient.store(content);
        String content2 = storageClient.retrieve(key);

        assertEquals(content, content2);
    }

}
