package com.epam.preprod.hrabovska.model.entity;

/**
 * Class describes an abstract Entity in database
 */
public abstract class Entity {

    private Long id;

    Entity() {
        this.id = generateId();
    }

    private Long generateId() {
        return System.nanoTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        return id.equals(entity.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}