package com.epam.preprod.hrabovska.model.bean;

/**
 * Filter parameters for client
 */
public class FilterBean {
    private static final String SORT_TYPE_DEFAULT = "ASC";
    private static final String SORT_DEFAULT = "name";
    private static final int PAGE_DEFAULT = 1;
    private static final int LIMIT_DEFAULT = 2;
    public static final String NAME = SORT_DEFAULT;

    public static final String CATEGORY = "category";
    public static final String BRAND = "brand";
    public static final String PRICE_FROM = "priceFrom";
    public static final String PRICE_TO = "priceTo";
    public static final String LIMIT = "limit";
    public static final String SORT = "sort";
    public static final String SORT_TYPE = "type";
    public static final String PAGE = "page";

    private String name;
    private String[] category;
    private String[] brands;
    private String priceFrom;
    private String priceTo;
    private Integer limit;
    private Integer page;
    private String sort;
    private String sortType;

    public FilterBean() {
        this.limit = LIMIT_DEFAULT;
        this.page = PAGE_DEFAULT;
        this.sort = SORT_DEFAULT;
        this.sortType = SORT_TYPE_DEFAULT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCategory() {
        return category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }

    public String[] getBrands() {
        return brands;
    }

    public void setBrands(String[] brands) {
        this.brands = brands;
    }

    public String getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
    }

    public String getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(String priceTo) {
        this.priceTo = priceTo;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String type) {
        this.sortType = type;
    }

}
