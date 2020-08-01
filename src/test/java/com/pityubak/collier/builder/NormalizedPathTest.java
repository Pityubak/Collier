package com.pityubak.collier.builder;

import java.net.URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Pityubak
 */
public class NormalizedPathTest {
    
    private final String rawPath;

    public NormalizedPathTest() {
        Class<?> targetClass = ClassFilePathsTest.class;
        String className = targetClass.getSimpleName() + ".class";
        URL url = targetClass.getResource(className);
        rawPath = url.getPath();
    }

    /**
     * Test of getNormalizedPath method, of class NormalizedPath.
     */
    @Test
    public void testGetNormalizedPath() {
        NormalizedPath instance = new NormalizedPath(rawPath);
        String expResult = "/E:/Mywork/java/Collier/target/test-classes/com/pityubak/collier/ClassFilePathsTest.class";
        String result = instance.getNormalizedPath();
        assertEquals(expResult, result);

    }
    
}
