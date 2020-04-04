package category;

import models.Category;
import search.BoyerMooreAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class CategoryFinder implements Callable<Map<String, List<String>>>{

    private final String text;
    private final String url;
    private final List<Category> categoryList;

    private BoyerMooreAlgorithm occurrencesSearcher = new BoyerMooreAlgorithm();

    public CategoryFinder(String url, String text, List<Category> categoryList) {
        this.url = url;
        this.text = text;
        this.categoryList = categoryList;
    }

    private boolean findFirstOccurrence(String pattern){
        return occurrencesSearcher.searchFirstOccurrence(text, pattern);
    }

    @Override
    public Map<String, List<String>> call(){
        List<String> categories = new ArrayList<>();
        Map<String, List<String>> foundCategory = new HashMap<>();
        for (Category category : categoryList) {
            for (String pattern : category.getCategoryWords()) {
                boolean found = findFirstOccurrence(pattern);
                if (found) {
                    categories.add(category.getCategoryName());
                    break;
                }
            }
        }
        if (!categories.isEmpty()){
            foundCategory.put(url, categories);
        }
        return foundCategory;
    }
}
