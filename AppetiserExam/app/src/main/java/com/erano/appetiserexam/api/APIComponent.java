package com.erano.appetiserexam.api;

import com.erano.appetiserexam.module.ItunesDetailModule;
import com.erano.appetiserexam.module.ItunesModule;
import com.erano.appetiserexam.ui.activity.ItunesActivity;
import com.erano.appetiserexam.ui.activity.ItunesDetailActivity;

import javax.inject.Singleton;

import dagger.Subcomponent;

/**
 * Created by Eraño Payawal on 2019-08-17.
 * hunterxer31@gmail.com
 */
@UrlScope
@Singleton
@Subcomponent(modules = {
        // dependency
        APIModule.class,
        ItunesModule.class,
        ItunesDetailModule.class
    }
)
public interface APIComponent {

    void inject(ItunesActivity itunesActivity);

    void inject(ItunesDetailActivity itunesDetailActivity);

}
