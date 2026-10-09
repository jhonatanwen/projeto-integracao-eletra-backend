package com.eletra.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Model>  models;

    public Category(String name) {
        this.name = name;
        this.models = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Model> getModels() {
        return models;
    }

    public void addModel(Model model) {
        this.models.add(model);
    }

    @Override
    public String toString() {
        return name;
    }
}
