package com.elegidocodes.androidtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Extra {

    @SerializedName("video_welcome")
    @Expose
    private String videoWelcome;

    public String getVideoWelcome() {
        return videoWelcome;
    }

    public void setVideoWelcome(String videoWelcome) {
        this.videoWelcome = videoWelcome;
    }

}
