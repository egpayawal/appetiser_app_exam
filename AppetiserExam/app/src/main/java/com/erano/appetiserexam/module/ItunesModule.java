package com.erano.appetiserexam.module;

import com.erano.appetiserexam.Impl.ItunesActivityImpl;
import com.erano.appetiserexam.api.APIService;
import com.erano.appetiserexam.dao.ItunesDao;
import com.erano.appetiserexam.datasource.ItunesDataSource;
import com.erano.appetiserexam.datasource.ItunesRepository;
import com.erano.appetiserexam.model.ItunesModel;
import com.erano.appetiserexam.presenter.ItunesActivityPresenter;
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
public class ItunesModule {

    @Provides
    public ItunesActivityImpl.Presenter provideItunesActivityPresenter(ItunesActivityImpl.Model model,
                                                                       RxSchedulerConfiguration rxSchedulerConfiguration,
                                                                       Utils utils) {
        return new ItunesActivityPresenter(model, rxSchedulerConfiguration, utils);
    }

    @Provides
    public ItunesActivityImpl.Model provideItunesModel(ItunesRepository repository) {
        return new ItunesModel(repository);
    }

    @Provides
    @Singleton
    public ItunesRepository provideItunesRepo(APIService apiService,
                                              ItunesDao itunesDao) {
        return new ItunesDataSource(apiService, itunesDao);
    }

}
