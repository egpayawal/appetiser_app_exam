package com.erano.appetiserexam.presenter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.erano.appetiserexam.Impl.ItunesActivityImpl;
import com.erano.appetiserexam.util.RxSchedulerConfiguration;
import com.erano.appetiserexam.util.Utils;
import com.erano.appetiserexam.viewmodel.ItunesData;
import com.erano.appetiserexam.viewmodel.ItunesResponse;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.realm.Realm;
import io.realm.RealmResults;
import rx.Subscriber;
import rx.Subscription;

import static com.erano.appetiserexam.util.AppConstants.SCREEN_DETAIL;
import static com.erano.appetiserexam.util.AppConstants.SCREEN_MAIN;

/**
 * Created by Eraño Payawal on 2019-08-17.
 * hunterxer31@gmail.com
 */
public class ItunesActivityPresenter implements ItunesActivityImpl.Presenter {

    @Nullable
    private ItunesActivityImpl.View mView;
    private ItunesActivityImpl.Model mModel;
    private RxSchedulerConfiguration mrxSchedulerConfiguration;
    private Utils mUtils;

    private Realm mRealm;
    private Disposable mSubscriptionUIItunes;
    private Subscription mSubscriptionItunes;

    public ItunesActivityPresenter(ItunesActivityImpl.Model model,
                                   RxSchedulerConfiguration rxSchedulerConfiguration,
                                   Utils utils) {
        this.mModel = model;
        this.mrxSchedulerConfiguration = rxSchedulerConfiguration;
        this.mUtils = utils;
    }

    @Override
    public void rxUISubscribe() {
        mRealm = Realm.getDefaultInstance();

        if (mView != null) {
            if (mSubscriptionUIItunes == null || mSubscriptionUIItunes.isDisposed()) {
                mSubscriptionUIItunes = mRealm
                        .where(ItunesData.class)
                        .findAllAsync()
                        .asFlowable()
                        .filter(RealmResults::isLoaded)
                        .filter(RealmResults::isValid)
                        .filter(itunesData -> itunesData != null)
                        .observeOn(mrxSchedulerConfiguration.getMainThread())
                        .subscribe(itunesData -> {

                            if (itunesData != null) {
                                List<ItunesData> list = mRealm.copyFromRealm(itunesData);

                                if (list != null) {

                                    Log.e("DEBUG", "COUNT:: " + list.size());

                                    if (list.size() > 0) {
                                        mView.showEmptyState(false);
                                    } else {
                                        mView.showEmptyState(true);
                                    }

                                    mView.updateAdapter(list);
                                    mView.cancelShowToRefreshAnim();

                                }
                            }

                        }, Throwable::printStackTrace);
            }
        }
    }

    @Override
    public void rxUnsubscribe() {
        if (mSubscriptionUIItunes != null && !mSubscriptionUIItunes.isDisposed()) {
            mSubscriptionUIItunes.dispose();
        }

        if (mSubscriptionItunes != null && !mSubscriptionItunes.isUnsubscribed()) {
            mSubscriptionItunes.unsubscribe();
        }
    }

    @Override
    public void setView(ItunesActivityImpl.View view) {
        this.mView = view;
    }

    @Override
    public void initViews() {
        if (mView != null) {
            mView.setupToolbar();
            mView.setupAdapter();
            mView.setupPullToRefresh();
        }
    }

    @Override
    public void loadData() {
        search();
    }

    @Override
    public void checkLastScreen() {
        if (mView != null) {
            if (mUtils != null) {
                String lastScreen = mUtils.getLastScreen();
                String releaseDate = mUtils.getId(); // this is the Id from the last screen visited

                if (!TextUtils.isEmpty(lastScreen) && lastScreen.equalsIgnoreCase(SCREEN_DETAIL)
                        && !TextUtils.isEmpty(releaseDate)) {
                    mView.showDetailScreen(releaseDate);
                }

            }
        }
    }

    @Override
    public void saveLastScreen() {
        if (mUtils != null) {
            mUtils.saveScreen(SCREEN_MAIN);
            mUtils.saveId("");
        }
    }

    @Override
    public void setEmptyLastScreen() {
        if (mUtils != null) {
            mUtils.saveId("");
        }
    }

    private void search() {
        if (mView != null && mModel != null) {
            mView.showSwipeToRefreshAnim();
            mSubscriptionItunes = mModel.getItunesResult()
                    .subscribe(new Subscriber<ItunesResponse>() {
                        @Override
                        public void onCompleted() {
                            mView.cancelShowToRefreshAnim();
                        }

                        @Override
                        public void onError(Throwable e) {
                            mView.cancelShowToRefreshAnim();
                            mView.showErrorMessage(e.getMessage());
                        }

                        @Override
                        public void onNext(ItunesResponse itunesResponse) {
                            mView.cancelShowToRefreshAnim();
                        }
                    });
        }
    }

}
