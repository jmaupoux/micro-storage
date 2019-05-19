package micro.storage.ext;

import io.micronaut.core.convert.ConversionContext;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringToPathConverterTest {

    private StringToPathConverter stringToPathConverter = new StringToPathConverter();

    @Test
    public void convertTest(){
        Optional path = stringToPathConverter.convert("/tmp", Path.class, ConversionContext.DEFAULT);

        assertTrue(path.isPresent());
        assertEquals(Paths.get("/tmp"), path.get());
    }

    @Test
    public void convertTestNullOrEmpty(){
        Optional path = stringToPathConverter.convert(null, Path.class, ConversionContext.DEFAULT);

        assertFalse(path.isPresent());

        path = stringToPathConverter.convert("", Path.class, ConversionContext.DEFAULT);

        assertFalse(path.isPresent());
    }

}