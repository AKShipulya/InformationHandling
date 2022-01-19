package com.epam.informationHandling.service.impl;

import com.epam.informationHandling.entity.Component;
import com.epam.informationHandling.entity.Composite;
import com.epam.informationHandling.service.InformationService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InformationServiceImpl implements InformationService {

    public List<Component> sortBySentencesQuantity(Composite text) {
        return text.getComponents()
                .stream()
                .sorted(Comparator.comparing(paragraph -> paragraph.getComponents().stream().count()))
                .collect(Collectors.toList());
    }

    public List<Component> sortWordsInSentenceByLong(Composite text) {
        return text.getComponents()
                .stream()
                .sorted(Comparator.comparing(sentence -> sentence.getComponents().stream().count()))
                .collect(Collectors.toList());
    }

}
