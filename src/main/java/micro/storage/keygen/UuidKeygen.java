package micro.storage.keygen;

import io.micronaut.context.annotation.Requires;

import javax.inject.Singleton;
import java.util.UUID;

@Singleton
@Requires(property = "ms.keygen", value = "uuid")
public class UuidKeygen implements Keygen{
    public String generate(){
        return UUID.randomUUID().toString();
    }
}
