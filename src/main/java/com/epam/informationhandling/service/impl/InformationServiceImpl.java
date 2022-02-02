package com.epam.informationhandling.service.impl;

import com.epam.informationhandling.entity.Component;
import com.epam.informationhandling.exception.TextException;
import com.epam.informationhandling.service.InformationService;

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
                .sorted(Comparator.comparing(Component::getLexeme))
                .collect(Collectors.toList());
    }

    public String restoreTextFromComponent(Component text) throws TextException {
        if (text.getComponents().isEmpty()) {
            throw new TextException("Components for calculation are not provided!");
        }
        return text.getComponents()
                .stream()
                .map(Component::getLexeme)
                .collect(Collectors.joining(" "));
    }
}
