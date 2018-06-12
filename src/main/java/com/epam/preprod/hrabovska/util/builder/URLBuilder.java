package com.epam.preprod.hrabovska.util.builder;

import com.epam.preprod.hrabovska.model.bean.FilterBean;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import static com.epam.preprod.hrabovska.model.bean.FilterBean.*;

/**
 * URLBuilder class
 */
public class URLBuilder {
    private StringBuilder builder;

    public URLBuilder(String servletName) {
        builder = new StringBuilder(servletName + "?");
    }

    private void addParameter(String paramName, String paramValue) {
        if (StringUtils.isNotBlank(paramValue)) {
            builder.append(paramName).append("=").append(paramValue).append("&");
        }
    }

    private void addParameters(String paramName, String[] paramValue) {
        if (ArrayUtils.isNotEmpty(paramValue)) {
            for (String item : paramValue) {
                builder.append(paramName).append("=").append(item).append("&");
            }
        }
    }

    public void fillFilterStateFromFilterBean(FilterBean filterBean) {
        addParameter(NAME, filterBean.getName());
        addParameters(CATEGORY, filterBean.getCategory());
        addParameters(BRAND, filterBean.getBrands());
        addParameter(PRICE_FROM, filterBean.getPriceFrom());
        addParameter(PRICE_TO, filterBean.getPriceTo());
    }

    public void fillOrdersFromFilterBean(FilterBean filterBean) {
        addParameter(SORT, filterBean.getSort());
    }

    public void fillLimitsFromFilterBean(FilterBean filterBean) {
        addParameter(LIMIT, String.valueOf(filterBean.getLimit()));
    }

    public void fillPageFromFilterBean(FilterBean filterBean) {
        addParameter(PAGE, String.valueOf(filterBean.getPage()));
    }

    public String getUrl() {
        return builder.substring(0, builder.length() - 1);
    }
}
