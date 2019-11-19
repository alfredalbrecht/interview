package de.telekom.interviewexercise.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TextProcessorImplTest {
    @Test
    void mapWillMapAStringToDomainObject() {
        String value = "MyText";
        TextProcessorImpl textProcessor = new TextProcessorImpl();
        Text text = textProcessor.map(value);

        Assertions.assertEquals(text.getValue(), value);
    }
}