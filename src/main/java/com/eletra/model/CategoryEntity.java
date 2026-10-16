package com.eletra.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_id", nullable = false)
    private LineEntity line;

    public CategoryEntity() {}

    public CategoryEntity(String name, LineEntity line) {
        this.name = name;
        this.line = line;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LineEntity getLine() { return line; }
    public void setLine(LineEntity line) { this.line = line; }

    @Override
    public String toString() {
        return this.name;
    }
}
