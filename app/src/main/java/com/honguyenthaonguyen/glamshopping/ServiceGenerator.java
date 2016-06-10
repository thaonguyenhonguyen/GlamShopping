package com.honguyenthaonguyen.glamshopping;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by NGUYEN on 6/7/2016.
 */
public class ServiceGenerator {
    public static final String BASE_URL = "http://lshxf6oyz-site.gtempurl.com/wp/wc-api/v3/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .addInterceptor(new BasicAuthInterceptor());

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());
    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }
}
