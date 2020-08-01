package com.pityubak.collier.builder;

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
public class ClassFilePathsTest {

    public ClassFilePathsTest() {
    }

    /**
     * Test of getParsedPathList method, of class FileParsedPath.
     */
    @Test
    public void testGetParsedPathList() {

        FileParsedPath instance = new FileParsedPath("E:\\Mywork\\java\\Collier\\target\\classes\\com\\pityubak\\collier");
        List<Path> result = instance.getParsedPathList();
        assertEquals(18,result.size());
    }

    @Test
    public void testGetParsedPathListThrowException() {

        FileParsedPath instance = new FileParsedPath("E:\\Mywork\\java\\Collier\\target\\classes\\com\\pityubak\\collier2");
        Exception ex = assertThrows(PathParsingException.class,
                () -> instance.getParsedPathList());
        String message = ex.getMessage();
        assertTrue(message.contains("Parsing of path from file system failed"));
        ;
    }

}
