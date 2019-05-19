package micro.storage.purge;

import io.micronaut.context.annotation.Value;
import io.micronaut.scheduling.annotation.Scheduled;
import micro.storage.StorageRegistry;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.nio.file.Path;

@Singleton
public class PurgeTask {

    @Inject
    private StorageRegistry storageRegistry;

    @Value("${ms.storage.purge.file}")
    private Path path;

    @Scheduled(fixedRate = "${ms.storage.purge.frequency}")
    void cleanup() {

    }
}