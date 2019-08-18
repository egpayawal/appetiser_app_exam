package com.erano.appetiserexam.datasource;

import com.erano.appetiserexam.dao.ItunesDao;
import com.erano.appetiserexam.viewmodel.ItunesData;

/**
 * Created by Eraño Payawal on 2019-08-18.
 * hunterxer31@gmail.com
 */
public class ItunesDetailDataSource implements ItunesDetailRepository {

    private ItunesDao itunesDao;

    public ItunesDetailDataSource(ItunesDao itunesDao) {
        this.itunesDao = itunesDao;
    }

    @Override
    public ItunesData getItunesDetail(String releaseDate) {
        return itunesDao.getItunesDetail(releaseDate);
    }

}
