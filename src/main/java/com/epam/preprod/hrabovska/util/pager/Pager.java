package com.epam.preprod.hrabovska.util.pager;

import com.epam.preprod.hrabovska.model.bean.FilterBean;
import com.epam.preprod.hrabovska.util.builder.URLBuilder;
import com.epam.preprod.hrabovska.web.Path;

import java.util.LinkedHashMap;
import java.util.Map;

public class Pager {
    private static final String PAGE_PARAM_NAME = "&page=";
    private final int limit = 2;
    private final String PREV_TEXT = "Prev";
    private final String NEXT_TEXT = "Next";

    private int totalCountOfProducts;
    private FilterBean filterBean;

    public Pager(int totalCountOfProducts, FilterBean filterBean) {
        this.totalCountOfProducts = totalCountOfProducts;
        this.filterBean = filterBean;
    }

    public Map<String, String> generatePagination() {
        int totalPages = calculatePageCount(totalCountOfProducts, filterBean.getLimit());
        Map<String, String> pages = new LinkedHashMap<>();

        if (totalPages == 1) {
            return pages;
        }
        URLBuilder urlBuilder = fillBuilderFromCondition(filterBean);

        if (filterBean.getPage() > 1) {
            pages.put(PREV_TEXT, urlBuilder.getUrl() + PAGE_PARAM_NAME + (filterBean.getPage() - 1));
        }

        int pageCount = 2 * limit + 1;
        int left = Math.max(2, filterBean.getPage() - 2 * limit - 1);
        int right = Math.min(totalPages - 1, filterBean.getPage() + 2 * limit + 1);

        while (right - left > 2 * limit) {
            if (filterBean.getPage() - left < right - filterBean.getPage()) {
                right--;
                right = right < filterBean.getPage() ? filterBean.getPage() : right;
            } else {
                left++;
                left = left > filterBean.getPage() ? filterBean.getPage() : left;
            }
        }

        pages.put(String.valueOf(1), urlBuilder.getUrl() + PAGE_PARAM_NAME + 1);
        for (int i = 1, out = left; i <= pageCount && out <= right; i++, out++) {
            pages.put(String.valueOf(out), urlBuilder.getUrl() + PAGE_PARAM_NAME + out);
        }
        pages.put(String.valueOf(totalPages), urlBuilder.getUrl() + PAGE_PARAM_NAME + totalPages);

        if (filterBean.getPage() < totalPages) {
            pages.put(NEXT_TEXT, urlBuilder.getUrl() + PAGE_PARAM_NAME + (filterBean.getPage() + 1));
        }
        return pages;
    }

    private int calculatePageCount(int countOfProduct, int limit) {
        if (countOfProduct >= limit) {
            if (countOfProduct % limit == 0) {
                return countOfProduct / limit;
            } else {
                return countOfProduct / limit + 1;
            }
        } else {
            return 1;
        }
    }

    private URLBuilder fillBuilderFromCondition(FilterBean filterBean) {
        URLBuilder urlBuilder = new URLBuilder(Path.CATEGORY_SERVLET);
        urlBuilder.fillFilterStateFromFilterBean(filterBean);
        urlBuilder.fillOrdersFromFilterBean(filterBean);
        urlBuilder.fillLimitsFromFilterBean(filterBean);
        return urlBuilder;

    }
}
