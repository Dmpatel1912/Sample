package com.projectactivity.deep.sample;

import com.google.gson.annotations.SerializedName;

public class ModelFeedback {

    @SerializedName("EnrollNo")
    private String enroll;

    @SerializedName("FeedbackDescription")
    private String feedback_description;

    public ModelFeedback(String enroll, String feedback_description) {
        this.enroll = enroll;
        this.feedback_description = feedback_description;
    }

    public String getEnroll() {
        return enroll;
    }

    public void setEnroll(String enroll) {
        this.enroll = enroll;
    }

    public String getFeedback_description() {
        return feedback_description;
    }

    public void setFeedback_description(String feedback_description) {
        this.feedback_description = feedback_description;
    }
}
