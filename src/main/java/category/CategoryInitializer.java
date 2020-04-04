package category;

import models.Category;

import java.util.List;

public class CategoryInitializer {

    public static Category initializeModel(String categoryName, List<String> words){
        Category category = new Category();
        category.setCategoryName(categoryName);
        category.setCategoryWords(words);

        return category;
    }
}
