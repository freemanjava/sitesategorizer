package search;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    private static final String WORD_BOUNDARY = "\\b";

    public static boolean search(String text, String keyWorld){
        String patternString = keyWordPreparation(keyWorld);
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    private static String keyWordPreparation(String keyWord){
        return WORD_BOUNDARY + keyWord + WORD_BOUNDARY;
    }
}
