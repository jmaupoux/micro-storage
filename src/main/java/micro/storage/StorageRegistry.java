package micro.storage;

import io.micronaut.context.annotation.Value;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Singleton
public class StorageRegistry {

    @Value("${ms.registry.location}")
    private Path location;

    @PostConstruct
    public void init() throws IOException {
        location.getParent().toFile().mkdir();
        location.toFile().createNewFile();
    }

    public void register(String id) throws IOException {
        Files.write(location, id.getBytes(StandardCharsets.ISO_8859_1), StandardOpenOption.APPEND);
    }
}