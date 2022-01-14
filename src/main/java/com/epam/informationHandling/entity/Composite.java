package com.epam.informationHandling.entity;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    private final List<Component> children = new ArrayList<>();
    private ComponentType type;

    public void add(Component child) {
        children.add(child);
    }

    public List<Component> getChildren() {
        return children;
    }

    @Override
    public ComponentType getComponentType() {
        return type;
    }
}
