package com.erano.appetiserexam.model;

import com.erano.appetiserexam.Impl.ItunesDetailActivityImpl;
import com.erano.appetiserexam.datasource.ItunesDetailRepository;
import com.erano.appetiserexam.viewmodel.ItunesData;

/**
 * Created by Eraño Payawal on 2019-08-18.
 * hunterxer31@gmail.com
 */
public class ItunesDetailModel implements ItunesDetailActivityImpl.Model {

    private ItunesDetailRepository repository;

    public ItunesDetailModel(ItunesDetailRepository repository) {
        this.repository = repository;
    }

    @Override
    public ItunesData getItunesDetailResult(String releaseDate) {
        return repository.getItunesDetail(releaseDate);
    }
}
