package com.eletra.dto;

public class LineDTO {
    private Integer id;
    private String name;

    public LineDTO() {}

    public LineDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Integer id;
        private String name;

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public LineDTO build() { return new LineDTO(id, name); }
    }
}
