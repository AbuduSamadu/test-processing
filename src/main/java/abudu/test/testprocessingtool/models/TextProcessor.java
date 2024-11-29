package abudu.test.testprocessingtool.models;


import abudu.test.testprocessingtool.services.RegexService;

public class TextProcessor {
    private final RegexService regexService;

    /**
     * Constructor initializes the TextProcessor with a RegexService instance.
     */
    public TextProcessor(RegexService regexService) {
        this.regexService = regexService;
    }

    public String search(String text, String regex) {
        regexService.validateRegex(regex);
        return String.join("\n", regexService.findAllMatches(text, regex));
    }

    public String replace(String text, String regex, String replacement) {
        regexService.validateRegex(regex);
        return regexService.replaceAllMatches(text, regex, replacement);
    }

    public String exactMatch(String text, String regex) {
        regexService.validateRegex(regex);
        return regexService.isExactMatch(text, regex);
    }
}