package com.erano.appetiserexam.datasource;

import com.erano.appetiserexam.viewmodel.ItunesResponse;

import rx.Observable;

/**
 * Created by Eraño Payawal on 2019-08-17.
 * hunterxer31@gmail.com
 */
public interface ItunesRepository {

    Observable<ItunesResponse> getItunes();

}
