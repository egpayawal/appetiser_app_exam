package com.erano.appetiserexam.presenter;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.erano.appetiserexam.Impl.ItunesDetailActivityImpl;
import com.erano.appetiserexam.util.Utils;
import com.erano.appetiserexam.viewmodel.ItunesData;

import static com.erano.appetiserexam.util.AppConstants.SCREEN_DETAIL;

/**
 * Created by Eraño Payawal on 2019-08-18.
 * hunterxer31@gmail.com
 */
public class ItunesDetailActivityPresenter implements ItunesDetailActivityImpl.Presenter {

    @Nullable
    private ItunesDetailActivityImpl.View mView;
    private ItunesDetailActivityImpl.Model mModel;
    private Utils mUtils;

    public ItunesDetailActivityPresenter(ItunesDetailActivityImpl.Model model,
                                         Utils utils) {
        this.mModel = model;
        this.mUtils = utils;
    }

    @Override
    public void setView(ItunesDetailActivityImpl.View view) {
        mView = view;
    }

    @Override
    public void initViews() {
        if (mView != null) {
            mView.setupToolbar();
        }
    }

    @Override
    public void loadData() {
        if (mView != null && mModel != null) {

            String releaseDate = mView.getId();
            ItunesData item = mModel.getItunesDetailResult(releaseDate);

            if (item != null) {

                String trackName = item.getTrackName();
                String genre = item.getPrimaryGenreName();
                String price = String.valueOf(item.getCollectionPrice());
                String imageUrl = item.getArtworkUrl100();
                String description = item.getLongDescription();

                if (!TextUtils.isEmpty(trackName)) {
                    mView.setTrackName(trackName);
                } else {
                    mView.setTrackName("");
                }

                if (!TextUtils.isEmpty(genre)) {
                    mView.setGenre(genre);
                } else {
                    mView.setGenre("");
                }

                if (!TextUtils.isEmpty(price)) {
                    price = "$" + price;
                    mView.setPrice(price);
                } else {
                    price = "$0.00";
                    mView.setPrice(price);
                }

                if (!TextUtils.isEmpty(imageUrl)) {
                    mView.setThumbnail(imageUrl);
                }

                if (!TextUtils.isEmpty(description)) {
                    mView.setDescription(description);
                } else {
                    mView.setDescription("");
                }

            }
        }
    }

    @Override
    public void saveLastScreen() {
        if (mView != null && mUtils != null) {
            String releaseDate = mView.getId();
            if (!TextUtils.isEmpty(releaseDate)) {
                mUtils.saveId(releaseDate);
            }
            mUtils.saveScreen(SCREEN_DETAIL);
        }
    }
}
