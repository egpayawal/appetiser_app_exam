package com.erano.appetiserexam.Impl;

import com.erano.appetiserexam.viewmodel.ItunesData;
import com.erano.appetiserexam.viewmodel.ItunesResponse;

import java.util.List;

import rx.Observable;

/**
 * Created by Eraño Payawal on 2019-08-17.
 * hunterxer31@gmail.com
 */
public interface ItunesActivityImpl {

    interface View {

        void setupToolbar();

        void setupAdapter();

        void setupPullToRefresh();

        void updateAdapter(List<ItunesData> list);

        void showSwipeToRefreshAnim();

        void cancelShowToRefreshAnim();

        void showEmptyState(boolean isVisible);

        void showErrorMessage(String message);

        void showDetailScreen(String releaseDate);

    }

    interface Presenter {

        void rxUISubscribe();

        void rxUnsubscribe();

        void setView(ItunesActivityImpl.View view);

        void initViews();

        void loadData();

        void checkLastScreen();

        void setEmptyLastScreen();

        void saveLastScreen();

    }

    interface Model {

        Observable<ItunesResponse> getItunesResult();

    }

}
