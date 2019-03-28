package com.projectactivity.deep.sample;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {


    @GET("details/{enroll}")
    Call<ModelStudent> getModelPost(@Path(value="enroll") String enroll);

    @POST("post")
    Call<ModelComplain> sendModel(@Body ModelComplain post);

    @POST("")
    Call<ModelFeedback> sendModel(@Body ModelFeedback post);
}
