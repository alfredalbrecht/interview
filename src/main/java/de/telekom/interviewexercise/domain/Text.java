package de.telekom.interviewexercise.domain;

import lombok.NonNull;
import lombok.Value;

@Value
public class Text {
    @NonNull
    private final String value;
}
