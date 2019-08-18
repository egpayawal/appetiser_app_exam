package com.erano.appetiserexam.module;

import com.erano.appetiserexam.Impl.ItunesDetailActivityImpl;
import com.erano.appetiserexam.dao.ItunesDao;
import com.erano.appetiserexam.datasource.ItunesDetailDataSource;
import com.erano.appetiserexam.datasource.ItunesDetailRepository;
import com.erano.appetiserexam.model.ItunesDetailModel;
import com.erano.appetiserexam.presenter.ItunesDetailActivityPresenter;
import com.erano.appetiserexam.util.Utils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Eraño Payawal on 2019-08-17.
 * hunterxer31@gmail.com
 */
@Module
public class ItunesDetailModule {

    @Provides
    public ItunesDetailActivityImpl.Presenter provideItunesDetailActivityPresenter(ItunesDetailActivityImpl.Model model,
                                                                                   Utils utils) {
        return new ItunesDetailActivityPresenter(model, utils);
    }

    @Provides
    public ItunesDetailActivityImpl.Model provideItunesDetailModel(ItunesDetailRepository repository) {
        return new ItunesDetailModel(repository);
    }

    @Provides
    @Singleton
    public ItunesDetailRepository provideItunesDetailRepo(ItunesDao itunesDao) {
        return new ItunesDetailDataSource(itunesDao);
    }

}
