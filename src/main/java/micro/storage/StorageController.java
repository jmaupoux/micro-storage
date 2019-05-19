package micro.storage;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.io.IOException;

@Controller("/value")
public class StorageController {

    @Inject
    private StorageService service;

    @Put(value = "/", consumes = MediaType.APPLICATION_OCTET_STREAM, produces = MediaType.TEXT_PLAIN)
    HttpResponse<String> put( @Body byte[] content)  {
        try {
            return HttpResponse.created(service.store(content));
        } catch (IOException e) {
            return HttpResponse.serverError();
        }
    }

    @Get(value = "/{id}", produces = MediaType.APPLICATION_OCTET_STREAM)
    public HttpResponse<byte[]> get(String id) {
        try {
            return HttpResponse.ok(service.read(id));
        } catch ( IOException e ) {
            return HttpResponse.noContent();
        }
    }

    @Delete(value = "/{id}")
    public HttpStatus delete(String id) {
        //TODO
        return HttpStatus.NO_CONTENT;
    }
}