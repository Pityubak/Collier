package com.pityubak.collier.link;

import com.pityubak.collier.builder.ClassInstanceCollector;
import com.pityubak.collier.builder.InstanceCollector;
import com.pityubak.collier.misc.ParsingTarget;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pityubak
 */
public class ClassFileFactoryTest {

    public ClassFileFactoryTest() {
    }

    /**
     * Test of generateInstanceCollector method, of class ClassFileFactory.
     */
    @Test
    public void testGenerateInstanceCollector() {
        ClassFileFactory instance = new ClassFileFactory(ParsingTarget.class);
        InstanceCollector result = instance.generateInstanceCollector();
        boolean isRightType = result instanceof ClassInstanceCollector;
        assertTrue(isRightType);
    }

}
