package com.erano.appetiserexam.api;

import com.erano.appetiserexam.viewmodel.ItunesResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Eraño Payawal on 2019-08-17.
 * hunterxer31@gmail.com
 */
public interface APIService {

    @GET("search?term=star&amp;country=au&amp;media=movie&amp;all")
    Observable<ItunesResponse> getSearchList();

}
