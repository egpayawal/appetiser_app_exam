package com.erano.appetiserexam.Impl;

import com.erano.appetiserexam.viewmodel.ItunesData;

/**
 * Created by Eraño Payawal on 2019-08-18.
 * hunterxer31@gmail.com
 */
public interface ItunesDetailActivityImpl {

    interface View {

        void setupToolbar();

        String getId();

        void setTrackName(String trackName);

        void setGenre(String genre);

        void setPrice(String price);

        void setThumbnail(String imageUrl);

        void setDescription(String description);

    }

    interface Presenter {

        void setView(ItunesDetailActivityImpl.View view);

        void initViews();

        void loadData();

        void saveLastScreen();

    }

    interface Model {

        ItunesData getItunesDetailResult(String releaseDate);

    }

}
