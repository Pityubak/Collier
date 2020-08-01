package com.pityubak.collier.link;

import com.pityubak.collier.builder.InstanceCollector;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author Pityubak
 */
public class CollectionBridge<J> implements Bridge<J> {

    private final InstanceCollector instanceCollection;
    private final InstanceCollectorFactory factory;

    public CollectionBridge(InstanceCollectorFactory factory) {
        this.factory = factory;
        this.instanceCollection = this.factory.generateInstanceCollector();
    }

    @Override
    public void collect(Consumer linkTo) {
        List<J> collectedClasses = instanceCollection.collect();
        collectedClasses.forEach(linkTo);
    }
}
