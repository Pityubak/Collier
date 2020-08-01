package com.pityubak.collier.link;

import com.pityubak.collier.builder.FileParsedPath;
import com.pityubak.collier.builder.ClassInstanceCollector;
import com.pityubak.collier.builder.InstanceCollector;
import com.pityubak.collier.builder.JarParsedPath;
import com.pityubak.collier.builder.ParsedPath;

/**
 *
 * @author Pityubak
 */
public class ClassFileFactory extends InstanceCollectorFactory {

    public ClassFileFactory(Class<?> entryClass) {
        super(entryClass);
    }

    @Override
    public InstanceCollector generateInstanceCollector() {
        if (this.inJar) {
            ParsedPath jarPath = new JarParsedPath(this.rawPath);
            return new ClassInstanceCollector(jarPath, entryClass);
        } else {
            ParsedPath classPath = new FileParsedPath(this.rawPath);
            return new ClassInstanceCollector(classPath, entryClass);
        }
    }

}
