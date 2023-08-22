package org.javaguru.immutables;

import org.immutables.value.Value;

@Value.Immutable
interface Book {

    @Value.Parameter
    String authorFullName();

    @Value.Parameter
    String title();

}
