package micro.storage.client;

import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;

@Client("/value")
public interface StorageClient {

    @Put(value = "/", produces = "application/octet-stream")
    String store(@Body String body);

    @Get("/{name}")
    String retrieve(String name);
}
