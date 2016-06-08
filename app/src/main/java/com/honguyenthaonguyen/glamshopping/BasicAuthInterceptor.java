package com.honguyenthaonguyen.glamshopping;

import android.util.Base64;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by NGUYEN on 6/7/2016.
 */
public class BasicAuthInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder requestBuilder = chain.request().newBuilder();

        String username = "ck_4d390ce15502d795f98fccefb4c8209ad8bcccde";
        String password = "cs_9c5ee4e532101a4589f740867dec33a9c40f2cad";
        String credentials = username + ":" + password;
        // create Base64 encodet string
        final String basic =
                "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
        requestBuilder.addHeader("Authorization", basic);
        return chain.proceed(requestBuilder.build());
    }
}
