package micro.storage.keygen;

import io.micronaut.context.annotation.Requires;
import org.apache.commons.lang.RandomStringUtils;

import javax.inject.Singleton;
import java.util.Base64;
import java.util.UUID;

@Singleton
@Requires(property = "ms.keygen", value = "human")
public class HumanFriendlyKeygen implements Keygen{

    private static final int LENGTH = 8;

    public String generate(){
        return RandomStringUtils.random(LENGTH, true, true);
    }
}
