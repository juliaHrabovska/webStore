package com.epam.preprod.hrabovska.model.entity;

/**
 * Brand entity
 */
public class Brand extends Entity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "name='" + name + '\'' +
                '}';
    }
}
