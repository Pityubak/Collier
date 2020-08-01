package com.pityubak.collier.builder;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Pityubak
 */
public class JavaInstanceCollector implements InstanceCollector<Path> {

    private final List<Path> cache = new ArrayList<>();
    private final ParsedPath parsedPath;

    public JavaInstanceCollector(ParsedPath parsedPath) {
        this.parsedPath = parsedPath;
        collectJavaFileToCache();
    }

    @Override
    public List<Path> collect() {
        return Collections.unmodifiableList(cache);
    }

    private void collectJavaFileToCache() {
        parsedPath.getParsedPathList().forEach(cache::add);
    }

}
