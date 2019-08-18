package com.erano.appetiserexam.model;

import com.erano.appetiserexam.Impl.ItunesActivityImpl;
import com.erano.appetiserexam.datasource.ItunesRepository;
import com.erano.appetiserexam.viewmodel.ItunesResponse;

import rx.Observable;

/**
 * Created by Eraño Payawal on 2019-08-17.
 * hunterxer31@gmail.com
 */
public class ItunesModel implements ItunesActivityImpl.Model {

    private ItunesRepository repository;

    public ItunesModel(ItunesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ItunesResponse> getItunesResult() {
        return repository.getItunes();
    }
}
