package com.epam.informationHandling.comparator;


import com.epam.informationHandling.entity.Component;
import com.epam.informationHandling.entity.Composite;

import java.util.Comparator;

public class ChildComponentsComparator implements Comparator<Composite> {
    @Override
    public int compare(Composite firstComposite, Composite secondComposite) {
        return firstComposite.getComponents().size() - secondComposite.getComponents().size();
    }
}