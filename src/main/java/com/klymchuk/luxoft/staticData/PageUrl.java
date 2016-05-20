package com.klymchuk.luxoft.staticData;

/**
 * Created by iklymchuk on 5/20/16.
 */
public enum PageUrl {

    HOME_PAGE("http://www.booking.com/"),
    SEARCH_PAGE("");

    private String pageUrl;

    private PageUrl (String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getPageUrl() {
        return pageUrl;
    }
}
