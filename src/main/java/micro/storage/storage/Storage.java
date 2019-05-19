package micro.storage.storage;

import java.io.IOException;

public interface Storage {

    void put(String id, byte[] content) throws IOException;

    byte[] get(String id) throws IOException;

    void clean(String id);
}
