package com.nipuni.apihandling.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostBody {
    /**
     * "name":"morphous"
     * "job":"leader"
     */

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("job")
    @Expose
    private String job;

    public PostBody(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
