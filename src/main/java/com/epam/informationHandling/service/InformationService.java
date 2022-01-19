package com.epam.informationHandling.service;

import com.epam.informationHandling.entity.Component;
import com.epam.informationHandling.entity.Composite;

import java.util.List;

public interface InformationService {
    List<Component> sortBySentencesQuantity(Composite text);

    List<Component> sortWordsInSentenceByLong(Composite text);
}
