package abudu.test.testprocessingtool.controllers;

import abudu.test.testprocessingtool.models.RegexProcessor;
import abudu.test.testprocessingtool.utils.RegexValidator;
import javafx.event.ActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * RegexProcessingController handles user interactions with regex-related functionality
 * such as validating, matching, finding all matches, and replacing patterns in text.
 */
public class RegexProcessingController {

    RegexProcessor regexProcessor;

    public RegexProcessingController() {
    }



    @NotNull
    static String getString(String text, String regex, RegexProcessor regexProcessor) {
        if (!RegexValidator.isValidRegex(regex)) {
            return "Invalid regex pattern.";
        }

        try {
            String[] matches = regexProcessor.findAllMatches(text, regex);
            return matches.length > 0 ? "Matches found: " + Arrays.toString(matches) : "No matches found.";
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }




    public String handleRegexValidation(String text, String regex) {
        return RegexValidator.isValidRegex(regex) ? "Valid regex pattern." : "Invalid regex pattern.";
    }
}