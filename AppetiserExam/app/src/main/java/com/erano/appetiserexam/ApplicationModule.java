package com.erano.appetiserexam;

import android.app.Application;
import android.content.Context;

import com.erano.appetiserexam.util.RxSchedulerConfiguration;
import com.erano.appetiserexam.util.Utils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Eraño Payawal on 2019-08-17.
 * hunterxer31@gmail.com
 */
@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    Utils provideUtils() {
        return new Utils(application);
    }

    @Provides
    @Singleton
    RxSchedulerConfiguration provideRxSchedulerConfiguration() {
        return new RxSchedulerConfiguration();
    }

}
