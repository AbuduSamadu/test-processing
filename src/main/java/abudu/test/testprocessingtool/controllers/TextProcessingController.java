package abudu.test.testprocessingtool.controllers;

import abudu.test.testprocessingtool.models.TextProcessor;
import abudu.test.testprocessingtool.models.RegexProcessor;
import abudu.test.testprocessingtool.services.RegexService;
import abudu.test.testprocessingtool.utils.Validator;


/**
 * TextProcessingController handles user interactions and delegates operations
 * to the appropriate processor classes for text and regex-related tasks.
 */
public class TextProcessingController {

    private final TextProcessor textProcessor ;
    private final RegexProcessor regexProcessor;
    /**
     * Constructor initializes the controller with instances of TextProcessor and RegexProcessor.
     */
    public TextProcessingController(){
        Validator validator = new Validator();
        RegexService regexService = new RegexService(new RegexProcessor(validator));
        this.textProcessor = new TextProcessor(regexService);
        this.regexProcessor = new RegexProcessor(validator);
    }



    // Implement the remaining methods as per the given requirements
    public String handleSearch(String text, String regex) {
        if (!Validator.isValidRegex(regex)) {
            return "Invalid regex pattern.";
        }
        String[] matches = textProcessor.search(text, regex).split("\n");
        int count = matches.length;
        return "Search: " + regex + ", Occurrences: " + count;
    }

    // Handle the replace operation
    public String handleReplace(String text, String regex, String replacement) {
        if (!Validator.isValidRegex(regex)) {
            return "Invalid regex pattern.";
        }
        try {
            return textProcessor.replace(text, regex, replacement);
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }

// Handle the exact match operation
public String handleExactMatch(String text, String regex) {
    if (!Validator.isValidRegex(regex)) {
        return "Invalid regex pattern.";
    }
    return textProcessor.exactMatch(text, regex);
}

}