package com.pityubak.collier.link;

import java.util.function.Consumer;

/**
 *
 * @author Pityubak
 */
public interface Bridge<J> {

    void collect(Consumer linkTo);

}
