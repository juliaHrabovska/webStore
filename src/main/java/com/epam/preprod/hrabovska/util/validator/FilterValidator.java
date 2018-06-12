package com.epam.preprod.hrabovska.util.validator;

import com.epam.preprod.hrabovska.model.bean.FilterBean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validate filter parameters
 */
public class FilterValidator {

    private static final String PRICE_SAMPLE = "^\\d+([,.]\\d{1,2})?$";
    private static final String CATEGORY_BRAND_LIMIT_PAGE_SAMPLE = "\\d+";
    private static final String SORT_SAMPLE = "(name)|(price)";

    private FilterBean filter;

    public FilterValidator(FilterBean filter) {
        this.filter = filter;
    }

    public boolean validate() {
        return isCategoryValid(filter.getCategory()) && isBrandValid(filter.getBrands()) &&
                isPriceValid(filter.getPriceFrom(), filter.getPriceTo()) && isLimitValid(filter.getLimit()) &&
                isSortValid(filter.getSort()) && isPageValid(filter.getPage());
    }

    private boolean isCategoryValid(String[] category) {
        if (category != null) {
            for (String s : category) {
                if (!validateField(s, CATEGORY_BRAND_LIMIT_PAGE_SAMPLE)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBrandValid(String[] brands) {
        if (brands != null) {
            for (String s : brands) {
                if (!validateField(s, CATEGORY_BRAND_LIMIT_PAGE_SAMPLE)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isPriceValid(String priceFrom, String priceTo) {
        return validateField(priceFrom, PRICE_SAMPLE) && validateField(priceTo, PRICE_SAMPLE);
    }

    private boolean isLimitValid(Integer limit) {
        return validateField(String.valueOf(limit), CATEGORY_BRAND_LIMIT_PAGE_SAMPLE);
    }

    private boolean isSortValid(String sort) {
        return validateField(sort, SORT_SAMPLE);
    }

    private boolean isPageValid(Integer page) {
        return  validateField(String.valueOf(page), CATEGORY_BRAND_LIMIT_PAGE_SAMPLE);
    }

    private static boolean validateField(String field, String regexp) {
        if (field == null) {
            return true;
        }
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(field);
        return matcher.matches();
    }
}
