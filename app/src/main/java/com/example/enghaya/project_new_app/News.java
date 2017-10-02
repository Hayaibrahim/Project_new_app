package com.example.enghaya.project_new_app;

import android.text.TextUtils;

/**
 * Created by ENG.HAYA on 10/2/2017 AD.
 */

public class News {

    private String title;
    private String url;
    private String section;
    private String date;
    private String athor;

    public News(String title, String url, String section, String date) {
        this.title = title;
        this.url = url;
        this.section = section;
        this.date = date;
    }

    public News(String title, String url, String section, String date, String athor) {
        this.title = title;
        this.url = url;
        this.section = section;
        this.date = date;
        this.athor = athor;
    }

    public News() {
    }

    public News(String title, String section, String url) {
        this.title = title;
        this.section = section;
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public String getAthor() {
        return athor;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getSection() {
        if (TextUtils.isEmpty(section)) {
            return "No section";
        }
        return section;
    }
}


