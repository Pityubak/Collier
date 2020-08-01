package com.pityubak.collier.link;

import com.pityubak.collier.builder.InstanceCollector;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

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

    @Override
    public <Q> Q collect(Function<List<J>, Q> function) {
        List<J> collectedClasses = instanceCollection.collect();
        return function.apply(collectedClasses);
    }

    @Override
    public void filter(Consumer filter) {
        List<J> collectedClasses = instanceCollection.collect();
        filter.accept(collectedClasses);
    }

}
