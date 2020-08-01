package com.pityubak.collier.builder;

/**
 *
 * @author Pityubak
 */
public class NormalizedPath {

    private String rawPath;

    public NormalizedPath(final String rawPath) {
        this.rawPath = rawPath;
    }

    public String getNormalizedPath() {
        if (rawPath.startsWith("jar:")) {
            rawPath = rawPath.substring(4);
        }
        if (rawPath.startsWith("file:")) {
            rawPath = rawPath.substring(5);

        }
        final int position = rawPath.indexOf("!/");

        rawPath = position == -1 ? rawPath : rawPath.substring(0, position);
        return rawPath;
    }

}
