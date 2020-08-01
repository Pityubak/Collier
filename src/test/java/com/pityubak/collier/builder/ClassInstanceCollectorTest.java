package com.pityubak.collier.builder;

import com.pityubak.collier.Collier;
import com.pityubak.collier.exception.ClassCollectException;
import com.pityubak.collier.exception.PathParsingException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author Pityubak
 */
public class ClassInstanceCollectorTest {

    public ClassInstanceCollectorTest() {
    }

    /**
     * Test of collect method, of class ClassInstanceCollector.
     */
    @Test
    public void testCollect() {
        ClassInstanceCollector instance
                = new ClassInstanceCollector(
                        new FileParsedPath("E:\\Mywork\\java\\Collier\\target\\classes\\com\\pityubak\\collier"),
                        Collier.class);
        List<Class<?>> result = instance.collect();
        boolean greaterThanNull = result.size() > 0;
        assertEquals(greaterThanNull, true);
    }

    @Test
    public void testCollectThrowException() {
        Exception ex = assertThrows(ClassCollectException.class,
                () -> new ClassInstanceCollector(
                        new FileParsedPath("E:\\Mywork\\java\\Collier\\target\\classes\\com\\pityubak\\collier"),
                        ClassInstanceCollectorTest.class));
        String message = ex.getMessage();
        System.out.println("Msg? " + message);
        assertTrue(message.contains("Error occured during collection process"));
    }

}
