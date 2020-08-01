package com.pityubak.collier.builder;

import com.pityubak.collier.exception.ClassCollectException;
import com.pityubak.collier.exception.PathParsingException;
import java.nio.file.Path;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author Pityubak
 */
public class JavaInstanceCollectorTest {

    public JavaInstanceCollectorTest() {
    }

    /**
     * Test of collect method, of class JavaInstanceCollector.
     */
    @Test
    public void testCollect() {
        JavaInstanceCollector instance
                = new JavaInstanceCollector(
                        new FileParsedPath("E:\\Mywork\\java\\Collier\\src\\main\\java\\com\\pityubak\\collier\\"));
        List<Path> result = instance.collect();
        boolean greaterThanNull = result.size() > 0;
        assertEquals(greaterThanNull, true);
    }

    @Test
    public void testCollectThrowEx() {
     Exception ex = assertThrows(PathParsingException.class,
                () -> new JavaInstanceCollector(
                        new FileParsedPath("E:\\Mywork\\java\\Collier\\targets\\classes\\com\\pityubak\\collier")));
        String message = ex.getMessage();
        assertTrue(message.contains("Parsing of path from file system failed"));
    }

}
