package de.telekom.interviewexercise.domain;

import org.springframework.stereotype.Component;

@Component
public class TextProcessorImpl implements TextProcessor {
    @Override
    public Text map(String text) {
        return new Text(text);
    }
}
