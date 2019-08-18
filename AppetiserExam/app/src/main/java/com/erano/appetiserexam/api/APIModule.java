package com.erano.appetiserexam.api;

import android.app.Application;

import com.erano.appetiserexam.BuildConfig;
import com.erano.appetiserexam.dao.ItunesDao;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Eraño Payawal on 2019-08-17.
 * hunterxer31@gmail.com
 */
@Module
public class APIModule {

    public APIModule() {

    }

    @Provides
    public String provideBaseUrl() {
        return BuildConfig.API_BASE_URL;
    }

    @Provides
    ItunesDao provideItunesDao() {
        return new ItunesDao();
    }

    @Provides
    @Singleton
    AuthenticationInterceptor provideInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Provides
    public OkHttpClient provideOkHttpClient(AuthenticationInterceptor interceptor) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.networkInterceptors().add(logging);
        }

        httpClient.connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .connectionPool(new ConnectionPool(3, 10, TimeUnit.MINUTES))
                .addInterceptor(interceptor);

        return httpClient.build();
    }

    @Provides
    public Retrofit provideRestAdapter(Application application, OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient)
                .baseUrl(provideBaseUrl())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()); // converter
        return builder.build();
    }

    @Provides
    public APIService provideAPIService(Retrofit restAdapter) {
        return restAdapter.create(APIService.class);
    }

}
