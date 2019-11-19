package de.telekom.interviewexercise.application.rest;

import de.telekom.interviewexercise.application.dto.TextResponseDto;
import de.telekom.interviewexercise.domain.Text;
import de.telekom.interviewexercise.domain.TextProcessor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RestController
@CrossOrigin
@Validated
@RequestMapping("/v1/processed")
@Api(tags = "A simple endpoint to manage strings and their anagrams")
public class TextRestController {

    private final TextProcessor textProcessor;

    public TextRestController(TextProcessor textProcessor) {
        this.textProcessor = textProcessor;
    }

    @ApiOperation("Deletes all anagrams for the given string")
    @ApiResponse(code = 200, message = "OK", response = TextResponseDto.class)
    @PostMapping(value = "/{reverse}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public TextResponseDto printString(
            @PathVariable("input")
            @NotBlank(message = "Must not be empty") @Size(max = 10, min = 2, message = "Must be between 2 and 10 characters long") String input
    )
    {
        return TextResponseDto.fromText(textProcessor.map(input));
    }
}
