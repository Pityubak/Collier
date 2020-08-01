package com.pityubak.collier.builder;

import com.pityubak.collier.exception.PathParsingException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 *
 * @author Pityubak
 */
public class JarParsedPath implements ParsedPath {

    private final String targetPath;

    public JarParsedPath(String targetPath) {
        this.targetPath = targetPath;
    }

    @Override
    public List<Path> getParsedPathList() {
        List<Path> parsedPath = new ArrayList<>();
        try {
            try (JarFile jarFile = new JarFile(targetPath)) {
                final Enumeration<JarEntry> entries = jarFile.entries();
                while (entries.hasMoreElements()) {
                    final JarEntry entry = entries.nextElement();
                    final String entryName = entry.getName();
                    parsedPath.add(Paths.get(targetPath + entryName));
                }
            }
        } catch (IOException ex) {
            throw new PathParsingException("Parsing of path from jar failed. Error: %s", ex.getMessage());
        }
          return Collections.unmodifiableList(parsedPath) ;
    }
  

}
