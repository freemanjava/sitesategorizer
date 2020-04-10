package search;

import java.util.Map;

public interface Searchable {
    boolean searchFirstOccurrence(String textString, String pattern);
    Map<String, Integer> searchAllOccurrences(String textString, String pattern);
}
