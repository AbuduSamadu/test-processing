package abudu.test.testprocessingtool.services;

import abudu.test.testprocessingtool.models.RegexProcessor;
import abudu.test.testprocessingtool.utils.Validator;


public class RegexService {

    private final RegexProcessor regexProcessor;


    // Initialize the RegexService with an instance of RegexProcessor
    public RegexService(RegexProcessor regexProcessor) {
        this.regexProcessor = regexProcessor;
    }

    // Validate the regex pattern
    public boolean validateRegex(String regex) {
        return !Validator.isValidRegex(regex);
    }

    // Find all matches in the text using the specified regex pattern
    public String[] findAllMatches(String text, String regex) {
        if (validateRegex(regex)) {
            throw new IllegalArgumentException("Invalid regex pattern.");
        }
        return regexProcessor.findAllMatches(text, regex);
    }

    // Check if the text matches the specified regex pattern
    public String isExactMatch(String text, String regex) {
        if (validateRegex(regex)) {
            throw new IllegalArgumentException("Invalid regex pattern.");
        }
        String[] matches = regexProcessor.findAllMatches(text, regex);
        return matches.length > 0 ? String.join(", ", matches) : "The text does not match the regex pattern.";
    }

    // Replace all matches in the text using the specified regex pattern and replacement
    public String replaceAllMatches(String text, String regex, String replacement) {
        if (validateRegex(regex)) {
            throw new IllegalArgumentException("Invalid regex pattern.");
        }
        return regexProcessor.replaceAll(text, regex, replacement);
    }
}