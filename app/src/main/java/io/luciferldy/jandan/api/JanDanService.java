package io.luciferldy.jandan.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Lucifer on 2017/3/19.
 */

public interface JanDanService {

    @GET("{date}")
    Call<ResponseBody> getNews(@Path("date") String date);

    @GET("duan/{date}")
    Call<ResponseBody> getJoke(@Path("date") String date);

    @GET("ooxx/{date}")
    Call<ResponseBody> getOOXX(@Path("date") String date);

    @GET("pic/{date}")
    Call<ResponseBody> getInteresting(@Path("date") String date);
}
