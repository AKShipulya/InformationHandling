package com.epam.informationHandling.service.impl;

import com.epam.informationHandling.entity.Component;
import com.epam.informationHandling.exception.TextException;
import com.epam.informationHandling.service.InformationService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InformationServiceImpl implements InformationService {

    public List<Component> sortBySentencesQuantity(Component text) throws TextException {
        if (text.getComponents().isEmpty()) {
            throw new TextException("Components for calculation are not provided!");
        }
        return text.getComponents()
                .stream()
                .sorted(Comparator.comparing(sentence -> sentence.getComponents().stream().count()))
                .collect(Collectors.toList());
    }

    public List<Component> sortWordsInSentenceByLong(Component text) throws TextException {
        if (text.getComponents().isEmpty()) {
            throw new TextException("Components for calculation are not provided!");
        }
        return text.getComponents()
                .stream()
                .sorted(Comparator.comparing(word -> word.getLexeme()))
                .collect(Collectors.toList());
    }

    public String restoreTextFromComponent(Component text) throws TextException {
        if (text.getComponents().isEmpty()) {
            throw new TextException("Components for calculation are not provided!");
        }
        return text.getComponents()
                .stream()
                .map(word -> word.getLexeme())
                .collect(Collectors.joining(" "));
    }
}
