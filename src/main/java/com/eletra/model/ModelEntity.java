package com.eletra.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_model")
public class ModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    public ModelEntity() {}

    public ModelEntity(String name, CategoryEntity category) {
        this.name = name;
        this.category = category;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() {
        return name;
    }

    public  CategoryEntity getCategory() { return category; }

    @Override
    public String toString() {
        return this.name;
    }
}
