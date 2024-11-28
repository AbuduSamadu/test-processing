package abudu.test.testprocessingtool.controllers;

import abudu.test.testprocessingtool.models.RegexProcessor;
import abudu.test.testprocessingtool.utils.RegexValidator;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class RegexProcessingController {

    // Create an instance of the RegexProcessor
    private final RegexProcessor regexProcessor;


     // Initialize the RegexProcessingController
    public RegexProcessingController() {
        this.regexProcessor = new RegexProcessor(new RegexValidator());
    }


    // Handle the regex processing operation
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

    public String[] findAllMatches(String text, String regex) {
        return regexProcessor.findAllMatches(text, regex);
    }

    public boolean matches(String text, String regex) {
        return regexProcessor.matches(text, regex);
    }

    public String replaceAll(String text, String regex, String replacement) {
        return regexProcessor.replaceAll(text, regex, replacement);
    }
}