package com.epam.informationHandling.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private static final Logger LOGGER = LogManager.getLogger();

    private final List<Component> components = new ArrayList<>();

    public Composite() {
    }

    public Composite(List<Component> components) {
        this.components.addAll(components);
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public Component getChild(int index) {
        return components.get(index);
    }

    public List<Component> getComponents() {
        return new ArrayList<>(components);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Composite composite = (Composite) object;
        return components != null ? components.equals(composite.components) : composite.components == null;
    }

    @Override
    public int hashCode() {
        return components != null ? components.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Composite{");
        stringBuilder.append("components=").append(components);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override
    public String getLexeme() {
        LOGGER.warn("Unsupported operation in class {}", this.getClass());
        throw new UnsupportedOperationException("This operation is not supported in this Class" + this.getClass());
    }
}
