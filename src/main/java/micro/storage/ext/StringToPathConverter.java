package micro.storage.ext;

import io.micronaut.core.convert.ConversionContext;
import io.micronaut.core.convert.TypeConverter;
import io.micronaut.core.util.StringUtils;

import javax.inject.Singleton;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

/**
 *     @Value("${key}")
 *     private Path root;
 */
@Singleton
public class StringToPathConverter implements TypeConverter<String, Path> {
    @Override
    public Optional<Path> convert(String object, Class<Path> targetType, ConversionContext context) {
        if(StringUtils.isEmpty(object)){
            return Optional.empty();
        }
        return Optional.of(Paths.get(object));
    }
}
