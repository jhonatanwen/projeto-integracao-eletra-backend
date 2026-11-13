package com.eletra.dto;

public class CategoryDTO {
    private Integer id;
    private String name;
    private Integer lineId;

    public CategoryDTO() {}

    public CategoryDTO(Integer id, String name, Integer lineId) {
        this.id = id;
        this.name = name;
        this.lineId = lineId;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getLineId() { return lineId; }
    public void setLineId(Integer lineId) { this.lineId = lineId; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Integer id;
        private String name;
        private Integer lineId;

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withLineId(Integer lineId) {
            this.lineId = lineId;
            return this;
        }

        public CategoryDTO build() {
            return new CategoryDTO(id, name, lineId);
        }
    }
}
