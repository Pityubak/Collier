package com.pityubak.collier.link;

import com.pityubak.collier.builder.FileParsedPath;
import com.pityubak.collier.builder.InstanceCollector;
import com.pityubak.collier.builder.JavaInstanceCollector;
import com.pityubak.collier.builder.ParsedPath;
import java.io.File;

/**
 *
 * @author Pityubak
 */
public class JavaFileFactory extends InstanceCollectorFactory {

    private final String OLDPATH = "target" + File.separator + "classes";
    private final String NEWPATH = "src" + File.separator + "main" + File.separator + "java";

    public JavaFileFactory(Class<?> entryClass) {
        super(entryClass);
    }

    @Override
    public InstanceCollector generateInstanceCollector() {
        final String modifiedPath = getJavaFilePath(this.rawPath);
        ParsedPath javaPath = new FileParsedPath(modifiedPath);
        return new JavaInstanceCollector(javaPath);
    }

    private String getJavaFilePath(String rawPath) {
        return rawPath.replace(OLDPATH, NEWPATH);
    }

}
