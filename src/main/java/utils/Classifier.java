package utils;

import category.CategoryMapper;
import models.Category;

import java.util.List;
import java.util.Map;

public class Classifier {

    public Map<String, List<String>> categorize(List<String> urls, List<Category> categories){
        CategoryMapper categoryMapper = new CategoryMapper(urls, categories);
        return categoryMapper.getCategoryMapping();
    }
}
