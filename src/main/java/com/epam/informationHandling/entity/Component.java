package com.epam.informationHandling.entity;

public interface Component {

    void add(Component child);

    ComponentType getComponentType();
}
