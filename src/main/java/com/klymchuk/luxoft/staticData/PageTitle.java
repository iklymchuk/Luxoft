package com.klymchuk.luxoft.staticData;

/**
 * Created by iklymchuk on 5/20/16.
 */
public enum  PageTitle {

    EMPTY(""),
    HOME_PAGE("");
    private String pageTitle;

    private PageTitle (String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageTitle() {
        return pageTitle;
    }
}
