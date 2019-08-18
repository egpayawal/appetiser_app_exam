package com.erano.appetiserexam.dao;

import com.erano.appetiserexam.viewmodel.ItunesData;
import com.erano.appetiserexam.viewmodel.ItunesResponse;

import io.realm.Realm;

/**
 * Created by Eraño Payawal on 2019-08-17.
 * hunterxer31@gmail.com
 */
public class ItunesDao {

    public void storeOrUpdate(ItunesResponse obj) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> realm1.insertOrUpdate(obj));
        realm.close();
    }

    public void deleteItunes() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> {
            realm1.delete(ItunesResponse.class);
        });
        realm.close();
    }

    public ItunesData getItunesDetail(String releaseDate) {
        Realm realm = Realm.getDefaultInstance();
        ItunesData obj = realm.where(ItunesData.class)
                .equalTo("releaseDate", releaseDate).findFirst();
        realm.close();
        return obj;
    }

}
