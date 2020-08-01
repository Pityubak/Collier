package com.pityubak.collier.link;

import com.pityubak.collier.builder.NormalizedPath;
import java.io.File;
import java.net.URL;

/**
 *
 * @author Pityubak
 */
public abstract class InstanceCollectorFactory implements Factory {

    protected final Class<?> entryClass;
    protected String rawPath;
    protected final boolean inJar;

    public InstanceCollectorFactory(Class<?> entryClass) {
        this.entryClass = entryClass;
        String raw = makeRawPath();
        this.inJar = startInJar(raw);
        this.rawPath = normalizePathURI(raw);
    }

    private String makeRawPath() {
        String className = entryClass.getSimpleName() + ".class";
        URL url = entryClass.getResource(className);
        return url.getPath();
    }

    private boolean startInJar(String raw) {
        return raw.contains(".jar!");
    }

    private String normalizePathURI(String raw) {
        String finalPath = raw;
        if (inJar) {
            NormalizedPath normalizedPath = new NormalizedPath(raw);
            finalPath = normalizedPath.getNormalizedPath();

        }
        File pathFile = new File(finalPath);
        return inJar ? pathFile.getPath() : pathFile.getParent();
    }

}
