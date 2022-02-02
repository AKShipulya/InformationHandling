package com.epam.informationhandling.service;

import com.epam.informationhandling.entity.Component;
import com.epam.informationhandling.exception.TextException;

import java.util.List;

public interface InformationService {
    List<Component> sortBySentencesQuantity(Component text) throws TextException;

    List<Component> sortWordsInSentenceByLong(Component text) throws TextException;

    String restoreTextFromComponent(Component text) throws TextException;
}
