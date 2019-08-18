package com.erano.appetiserexam.api;

import java.io.IOException;

import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Eraño Payawal on 2019-08-17.
 * hunterxer31@gmail.com
 */
@Singleton
public class AuthenticationInterceptor implements Interceptor {

    public AuthenticationInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder builder;

        builder = original.newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json");

        Request request = builder.build();
        return chain.proceed(request);
    }
}
