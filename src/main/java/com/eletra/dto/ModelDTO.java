package com.eletra.dto;

public class ModelDTO {
    private Integer id;
    private String name;
    private Integer categoryId;

    public ModelDTO() {}

    public ModelDTO(Integer id, String name, Integer categoryId) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Integer id;
        private String name;
        private Integer categoryId;

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public ModelDTO build() { return new ModelDTO(id, name, categoryId); }
    }
}
