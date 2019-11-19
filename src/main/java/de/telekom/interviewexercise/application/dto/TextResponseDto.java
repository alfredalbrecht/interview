package de.telekom.interviewexercise.application.dto;

import de.telekom.interviewexercise.domain.Text;
import lombok.NonNull;
import lombok.Value;

import java.util.Objects;

@Value
public class TextResponseDto {
    @NonNull
    private final String text;

    public static TextResponseDto fromText(Text text) {
        Objects.requireNonNull(text);

        return new TextResponseDto(text.getValue());
    }
}
