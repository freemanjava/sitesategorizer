package models;

import java.util.List;
import java.util.Objects;

public class Category {

    private Integer id;
    private String categoryName;
    private List<String> categoryWords;

    public Category() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<String> getCategoryWords() {
        return categoryWords;
    }

    public void setCategoryWords(List<String> categoryWords) {
        this.categoryWords = categoryWords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return id.equals(category.id) &&
                categoryName.equals(category.categoryName) &&
                categoryWords.equals(category.categoryWords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, categoryWords);
    }
}
