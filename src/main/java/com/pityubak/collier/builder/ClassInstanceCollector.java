package com.pityubak.collier.builder;

import com.pityubak.collier.exception.ClassCollectException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Pityubak
 */
public class ClassInstanceCollector implements InstanceCollector<Class<?>> {

    private final ParsedPath parsedPath;
    private final Class<?> entryClass;
    private final List<Class<?>> cache = new ArrayList<>();

    public ClassInstanceCollector(ParsedPath parsedPath, Class<?> entryClass) {
        this.parsedPath = parsedPath;
        this.entryClass = entryClass;
        collectClassesToCache();
    }

    @Override
    public List<Class<?>> collect() {
        return Collections.unmodifiableList(cache);
    }

    private void collectClassesToCache() {
        final Package pkg = entryClass.getPackage();
        final String packageName = pkg.getName();
        final List<Path> paths = parsedPath.getParsedPathList();

        paths.stream().map(Path::toString)
                .filter(fileName -> fileName.endsWith(".class"))
                .map(fileName -> fileName.replaceAll(".class", ""))
                .forEachOrdered((String file) -> {
                    String neededPart = getClassPathWithoutPkgName(file, packageName);
                    try {
                        final Class<?> loadedClass = Class.forName(packageName + neededPart);
                        cache.add(loadedClass);
                    } catch (ClassNotFoundException ex) {
                        throw new ClassCollectException(
                                "Error occured during collection process. %s", ex.getMessage());
                    }

                });
    }

    private String getClassPathWithoutPkgName(String file, final String packageName) {
        final String[] currentFile = file.split(packageName);
        String neededPart = currentFile[currentFile.length - 1];
        neededPart = neededPart.replace("\\", ".");
        return neededPart;
    }

}
