package com.eletra.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Category> categories;

    public Line(String name) {
        this.name = name;
        this.categories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    @Override
    public String toString() {
        return name;
    }
}
