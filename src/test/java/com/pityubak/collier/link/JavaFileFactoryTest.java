package com.pityubak.collier.link;

import com.pityubak.collier.builder.InstanceCollector;
import com.pityubak.collier.builder.JavaInstanceCollector;
import com.pityubak.collier.misc.ParsingTarget;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pityubak
 */
public class JavaFileFactoryTest {

    public JavaFileFactoryTest() {
    }

    /**
     * Test of generateInstanceCollector method, of class JavaFileFactory.
     */
    @Test
    public void testGenerateInstanceCollector() {
        JavaFileFactory instance = new JavaFileFactory(ParsingTarget.class);
        InstanceCollector result = instance.generateInstanceCollector();
        boolean isRightType = result instanceof JavaInstanceCollector;
        assertTrue(isRightType);
    }

}
