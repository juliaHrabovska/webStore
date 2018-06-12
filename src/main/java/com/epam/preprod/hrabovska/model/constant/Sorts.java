package com.epam.preprod.hrabovska.model.constant;

/**
 * Sorts enum
 */
public enum Sorts {
    NAME_ASK("name", "Name in ascending", "ASC"), NAME_DESC("name", "Name in descending", "DESC"), PRICE_ASK("price",
            "Price in ascending", "ASC"), PRICE_DESC("price", "Price in descending", "DESC");
    private String name;
    private String text;
    private String sortType;

    Sorts(String name, String text, String sortType) {
        this.name = name;
        this.text = text;
        this.sortType = sortType;
    }

    public String getName() {
        return this.name;
    }

    public String getText() {
        return this.text;
    }

    public String getSortType() {
        return this.sortType;
    }
}

