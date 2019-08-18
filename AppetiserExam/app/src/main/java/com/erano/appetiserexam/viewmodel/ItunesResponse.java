package com.erano.appetiserexam.viewmodel;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Eraño Payawal on 2019-08-17.
 * hunterxer31@gmail.com
 */
public class ItunesResponse extends RealmObject {

    private int resultCount;
    private RealmList<ItunesData> results;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public RealmList<ItunesData> getResults() {
        return results;
    }

    public void setResults(RealmList<ItunesData> results) {
        this.results = results;
    }
}
