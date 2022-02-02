package com.epam.informationhandling.entity;

import java.util.List;

public interface Component {
    List<Component> getComponents();
    String getLexeme();
}
