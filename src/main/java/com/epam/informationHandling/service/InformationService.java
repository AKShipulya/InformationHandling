package com.epam.informationHandling.service;

import com.epam.informationHandling.entity.Component;
import com.epam.informationHandling.exception.TextException;

import java.util.List;

public interface InformationService {
    List<Component> sortBySentencesQuantity(Component text) throws TextException;

    List<Component> sortWordsInSentenceByLong(Component text) throws TextException;

    String restoreTextFromComponent(Component text) throws TextException;
}
