package search.impl;

import search.Searchable;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex implements Searchable {

    private static final String WORD_BOUNDARY = "\\b";

    private static String keyWordPreparation(String keyWord){
        return WORD_BOUNDARY + keyWord + WORD_BOUNDARY;
    }

    @Override
    public boolean searchFirstOccurrence(String text, String keyWorld) {
        String patternString = keyWordPreparation(keyWorld);
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();    }

    @Override
    public Map<String, Integer> searchAllOccurrences(String textString, String pattern) {

        return null;
    }
}
