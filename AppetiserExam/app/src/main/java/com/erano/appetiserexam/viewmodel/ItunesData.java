package com.erano.appetiserexam.viewmodel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Eraño Payawal on 2019-08-17.
 * hunterxer31@gmail.com
 */
public class ItunesData extends RealmObject {

    private String wrapperType;
    private String kind;
    private long artistId;
    private long collectionId;
    private long trackId;
    private String artistName;
    private String collectionName;
    private long collectionArtistId;
    private String collectionArtistViewUrl;
    private String trackName;
    private String collectionCensoredName;
    private String trackCensoredName;
    private String artistViewUrl;
    private String collectionViewUrl;
    private String trackViewUrl;
    private String previewUrl;
    private String artworkUrl30;
    private String artworkUrl60;
    private String artworkUrl100;
    private double collectionPrice;
    private double trackPrice;
    private double trackRentalPrice;
    private double collectionHdPrice;
    private double trackHdPrice;
    private double trackHdRentalPrice;
    @PrimaryKey
    private String releaseDate;
    private String collectionExplicitness;
    private String trackExplicitness;
    private int discCount;
    private int discNumber;
    private int trackCount;
    private int trackNumber;
    private long trackTimeMillis;
    private String country;
    private String currency;
    private String primaryGenreName;
    private String contentAdvisoryRating;
    private String isStreamable;
    private String description;
    private String shortDescription;
    private String longDescription;
    private String copyright;
    private boolean hasITunesExtras;

    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public long getArtistId() {
        return artistId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    public long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(long collectionId) {
        this.collectionId = collectionId;
    }

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public long getCollectionArtistId() {
        return collectionArtistId;
    }

    public void setCollectionArtistId(long collectionArtistId) {
        this.collectionArtistId = collectionArtistId;
    }

    public String getCollectionArtistViewUrl() {
        return collectionArtistViewUrl;
    }

    public void setCollectionArtistViewUrl(String collectionArtistViewUrl) {
        this.collectionArtistViewUrl = collectionArtistViewUrl;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public double getCollectionPrice() {
        return collectionPrice;
    }

    public void setCollectionPrice(double collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    public double getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(double trackPrice) {
        this.trackPrice = trackPrice;
    }

    public double getTrackRentalPrice() {
        return trackRentalPrice;
    }

    public void setTrackRentalPrice(double trackRentalPrice) {
        this.trackRentalPrice = trackRentalPrice;
    }

    public double getCollectionHdPrice() {
        return collectionHdPrice;
    }

    public void setCollectionHdPrice(double collectionHdPrice) {
        this.collectionHdPrice = collectionHdPrice;
    }

    public double getTrackHdPrice() {
        return trackHdPrice;
    }

    public void setTrackHdPrice(double trackHdPrice) {
        this.trackHdPrice = trackHdPrice;
    }

    public double getTrackHdRentalPrice() {
        return trackHdRentalPrice;
    }

    public void setTrackHdRentalPrice(double trackHdRentalPrice) {
        this.trackHdRentalPrice = trackHdRentalPrice;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    public void setTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
    }

    public int getDiscCount() {
        return discCount;
    }

    public void setDiscCount(int discCount) {
        this.discCount = discCount;
    }

    public int getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(int discNumber) {
        this.discNumber = discNumber;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public long getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public void setTrackTimeMillis(long trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    public void setContentAdvisoryRating(String contentAdvisoryRating) {
        this.contentAdvisoryRating = contentAdvisoryRating;
    }

    public String getIsStreamable() {
        return isStreamable;
    }

    public void setIsStreamable(String isStreamable) {
        this.isStreamable = isStreamable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public boolean isHasITunesExtras() {
        return hasITunesExtras;
    }

    public void setHasITunesExtras(boolean hasITunesExtras) {
        this.hasITunesExtras = hasITunesExtras;
    }
}
