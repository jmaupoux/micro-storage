package micro.storage;

import micro.storage.keygen.Keygen;
import micro.storage.storage.Storage;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.util.UUID;

@Singleton
public class StorageService {

    @Inject
    private Storage storage;

    @Inject
    private StorageRegistry storageRegistry;

    @Inject
    private Keygen keygen;

    public String store(byte[] content) throws IOException {
        String id = keygen.generate();

        storage.put(id, content);
        storageRegistry.register(id);

        return id;
    }

    public byte[] read(String id) throws IOException{
        return storage.get(id);
    }
}