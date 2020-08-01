package com.pityubak.collier;

import com.pityubak.collier.link.Bridge;
import com.pityubak.collier.link.ClassFileFactory;
import com.pityubak.collier.link.CollectionBridge;
import com.pityubak.collier.link.InstanceCollectorFactory;
import com.pityubak.collier.link.JavaFileFactory;
import com.pityubak.collier.misc.ParsingTarget;
import java.util.function.Consumer;

/**
 *
 * @author Pityubak
 */
public class Collier {

    private final Bridge bridgeTo;

    public Collier(Class<?> collectingTarget, ParsingTarget target) {
        InstanceCollectorFactory factory
                = (target == ParsingTarget.CLASS_FILE) ? new ClassFileFactory(collectingTarget)
                        : new JavaFileFactory(collectingTarget);
        this.bridgeTo = new CollectionBridge(factory);
    }

    public void linkToCollector(Consumer consumer) {
        bridgeTo.collect(consumer);
    }

    public void linkToFiltering(Consumer filter) {
        bridgeTo.filter(filter);
    }

}
