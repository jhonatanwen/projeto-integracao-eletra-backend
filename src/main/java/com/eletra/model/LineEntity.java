package com.eletra.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_line")
public class LineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public LineEntity() {}

    public LineEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() { return id; }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
