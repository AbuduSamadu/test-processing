package abudu.test.testprocessingtool.services;

import abudu.test.testprocessingtool.models.RegexProcessor;
import abudu.test.testprocessingtool.utils.RegexValidator;


public class RegexService {

    private final RegexProcessor regexProcessor;

    public RegexService(RegexProcessor regexProcessor) {
        this.regexProcessor = regexProcessor;
    }


    public boolean validateRegex(String regex) {
        return !RegexValidator.isValidRegex(regex);
    }


    public String[] findAllMatches(String text, String regex) {
        if (validateRegex(regex)) {
            throw new IllegalArgumentException("Invalid regex pattern.");
        }
        return regexProcessor.findAllMatches(text, regex);
    }


    public boolean isExactMatch(String text, String regex) {
        if (validateRegex(regex)) {
            throw new IllegalArgumentException("Invalid regex pattern.");
        }
        return regexProcessor.matches(text, regex);
    }


    public String replaceAllMatches(String text, String regex, String replacement) {
        if (validateRegex(regex)) {
            throw new IllegalArgumentException("Invalid regex pattern.");
        }
        return regexProcessor.replaceAll(text, regex, replacement);
    }
}