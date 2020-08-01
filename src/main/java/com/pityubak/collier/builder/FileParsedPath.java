package com.pityubak.collier.builder;

import com.pityubak.collier.exception.PathParsingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Pityubak
 */
public class FileParsedPath implements ParsedPath {

    private final String targetPath;

    public FileParsedPath(String targetPath) {
        this.targetPath = targetPath;
    }

    @Override
    public List<Path> getParsedPathList() {
        List<Path> paths = new ArrayList<>();
        try (Stream<Path> list = Files.find(Paths.get(targetPath),
                Integer.MAX_VALUE,
                (, fileAttr) -> fileAttr.isRegularFile())) {

            list.forEach(paths::add);
        } catch (IOException ex) {
            throw new PathParsingException("Parsing of path from file system failed. Error: %s", ex.getMessage());
        }
        return Collections.unmodifiableList(paths);
    }

}
