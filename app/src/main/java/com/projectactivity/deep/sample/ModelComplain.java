package com.projectactivity.deep.sample;

import com.google.gson.annotations.SerializedName;

public class ModelComplain {

    @SerializedName("EnrollNo")
    private String enroll;

    @SerializedName("ComplainType")
    private String complain_type;

    @SerializedName("ComplainDescription")
    private String complain_description;

    public ModelComplain(String enroll, String complain_type, String complain_description) {
        this.enroll = enroll;
        this.complain_type = complain_type;
        this.complain_description = complain_description;
    }

    public String getEnroll() {
        return enroll;
    }

    public void setEnroll(String enroll) {
        this.enroll = enroll;
    }

    public String getComplain_type() {
        return complain_type;
    }

    public void setComplain_type(String complain_type) {
        this.complain_type = complain_type;
    }

    public String getComplain_description() {
        return complain_description;
    }

    public void setComplain_description(String complain_description) {
        this.complain_description = complain_description;
    }
}
