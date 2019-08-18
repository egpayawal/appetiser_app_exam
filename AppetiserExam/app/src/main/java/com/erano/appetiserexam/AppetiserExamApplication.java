package com.erano.appetiserexam;

import android.app.Application;

import com.erano.appetiserexam.api.APIComponent;
import com.erano.appetiserexam.api.APIModule;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Eraño Payawal on 2019-08-17.
 * hunterxer31@gmail.com
 */
public class AppetiserExamApplication extends Application {

    private static AppetiserExamApplication mInstance;
    private APIComponent mAPIComponent;
    private ApplicationComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

        initAppComponent();
        initRealm();
        initStetho();
    }

    public static synchronized AppetiserExamApplication getInstance() {
        return mInstance;
    }

    public APIComponent createAPIComponent() {
        mAPIComponent = null;
        mAPIComponent = mAppComponent.inject(new APIModule());
        return mAPIComponent;
    }

    public APIComponent getAPIComponent() {
        return mAPIComponent;
    }

    private void initAppComponent() {
        mAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        // default
        createAPIComponent();
    }

    public ApplicationComponent getComponent() {
        return mAppComponent;
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    private void initStetho() {
        if (BuildConfig.DEBUG) {
            Stetho.initialize(
                    Stetho.newInitializerBuilder(this)
                            .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                            .enableWebKitInspector(
                                    RealmInspectorModulesProvider.builder(this)
                                            .withDeleteIfMigrationNeeded(true) //if there is any changes in database schema then rebuild bd.
                                            .withMetaTables() //extract table meta data
                                            .withLimit(10000) //by default limit of data id 250, but you can increase with this
                                            .build()
                            )
                            .build());
        }
    }

}
