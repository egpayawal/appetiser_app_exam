package com.erano.appetiserexam;

import com.erano.appetiserexam.api.APIComponent;
import com.erano.appetiserexam.api.APIModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Eraño Payawal on 2019-08-17.
 * hunterxer31@gmail.com
 */
@Singleton
@Component(modules = {
        ApplicationModule.class
    }
)
public interface ApplicationComponent {

    APIComponent inject(APIModule apiModule);

}
