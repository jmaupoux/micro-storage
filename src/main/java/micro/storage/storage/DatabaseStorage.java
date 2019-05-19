package micro.storage.storage;

import io.micronaut.context.annotation.Requires;

import javax.inject.Singleton;
import java.io.IOException;
import java.nio.file.Path;

@Singleton
@Requires(property = "ms.storage.type", value = "db")
public class DatabaseStorage implements Storage {

    private Path path;

    public void put(String id, byte[] content) throws IOException {
        throw new UnsupportedOperationException();
    }

    public byte[] get(String id) throws IOException {
        throw new UnsupportedOperationException();
    }

    public void clean(String id){
        throw new UnsupportedOperationException();
    }
}
