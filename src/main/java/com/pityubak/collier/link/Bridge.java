package com.pityubak.collier.link;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 *
 * @author Pityubak
 */
public interface Bridge<J> {

    void collect(Consumer linkTo);

    void filter(Consumer filter);

    <Q> Q collect(Function<List<J>, Q> function);
}
