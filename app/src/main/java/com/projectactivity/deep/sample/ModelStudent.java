package com.projectactivity.deep.sample;

import com.google.gson.annotations.SerializedName;

public class ModelStudent {

    @SerializedName("EnrollNo")
    private String enroll;

    @SerializedName("FullName")
    private String full_name;

    @SerializedName("Sem")
    private int semester;

    @SerializedName("Branch")
    private String branch;

    @SerializedName("MobileNo")
    private String mobile;

    @SerializedName("EmailId")
    private String email;

    public ModelStudent(String enroll, String full_name, int semester, String branch, String mobile, String email) {


        this.enroll = enroll;
        this.full_name = full_name;
        this.semester = semester;
        this.branch = branch;
        this.mobile = mobile;
        this.email = email;
    }


    public String getEnroll() {
        return enroll;
    }

    public void setEnroll(String enroll) {
        this.enroll = enroll;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
