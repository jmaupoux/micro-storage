package micro.storage.storage;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.annotation.Value;
import org.apache.commons.io.IOUtils;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Singleton
@Requires(property = "ms.storage.type", value = "fs")
public class FsStorage implements Storage {

    @Value("${ms.storage.fs.path}")
    private Path root;

    public void put(String id, byte[] content) throws IOException {
        Path filePath = root.resolve(id);

        try (FileOutputStream fos = new FileOutputStream(filePath.toFile())){
            IOUtils.write(content, fos);
        }

    }

    public byte[] get(String id) throws IOException {
        Path filePath = root.resolve(id);

        try ( FileInputStream fis = new FileInputStream(filePath.toFile()) ) {
            return IOUtils.toByteArray(fis);
        }
    }

    public void clean(String id){

    }

    @PostConstruct
    public void init(){
        root.toFile().mkdir();
    }
}
