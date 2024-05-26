package com.nipuni.apihandling.models;

import android.view.ViewDebug;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserData {

    /**
     * {
     *     "page": 2,
     *     "per_page": 6,
     *     "total": 12,
     *     "total_pages": 2,
     *     "data": [
     *         {
     *             "id": 7,
     *             "email": "michael.lawson@reqres.in",
     *             "first_name": "Michael",
     *             "last_name": "Lawson",
     *             "avatar": "https://reqres.in/img/faces/7-image.jpg"
     *         }
     */

    @SerializedName("page")
    @Expose
    private int page;

    @SerializedName("per_page")
    @Expose
    private int per_page;

    @SerializedName("total")
    @Expose
    private int total;

    @SerializedName("total_pages")
    @Expose
    private int total_pages;

    @SerializedName("data")
    @Expose
    private ArrayList<UserDataList>userDataLists;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<UserDataList> getUserDataLists() {
        return userDataLists;
    }

    public void setUserDataLists(ArrayList<UserDataList> userDataLists) {
        this.userDataLists = userDataLists;
    }
}
