package com.erano.appetiserexam.datasource;

import com.erano.appetiserexam.api.APIService;
import com.erano.appetiserexam.dao.ItunesDao;
import com.erano.appetiserexam.viewmodel.ItunesResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Eraño Payawal on 2019-08-17.
 * hunterxer31@gmail.com
 */
public class ItunesDataSource implements ItunesRepository {

    private APIService apiService;
    private ItunesDao itunesDao;

    public ItunesDataSource(APIService apiService, ItunesDao itunesDao) {
        this.apiService = apiService;
        this.itunesDao = itunesDao;
    }

    @Override
    public Observable<ItunesResponse> getItunes() {
        return apiService.getSearchList()
                .map(new Func1<ItunesResponse, ItunesResponse>() {
                    @Override
                    public ItunesResponse call(ItunesResponse itunesResponse) {
                        if (itunesResponse != null) {
                            itunesDao.deleteItunes();
                            itunesDao.storeOrUpdate(itunesResponse);
                        }
                        return itunesResponse;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
