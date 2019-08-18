package com.erano.appetiserexam.datasource;

import com.erano.appetiserexam.viewmodel.ItunesData;

/**
 * Created by Eraño Payawal on 2019-08-18.
 * hunterxer31@gmail.com
 */
public interface ItunesDetailRepository {

    ItunesData getItunesDetail(String releaseDate);

}
