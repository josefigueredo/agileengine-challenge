package com.agileengine;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeightedElement {
    private final ElementAttributesPath elementAttributesPath;
    private final Double weight;
}
