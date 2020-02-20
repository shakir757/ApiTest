package com.example.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Get {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("img")
    @Expose
    private String url;

    @SerializedName("sub_title")
    @Expose
    private String sub_title;

    public Get(String title, String url, String sub_title) {
        this.title = title;
        this.url = url;
        this.sub_title = sub_title;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getSub_title() {
        return sub_title;
    }

}
