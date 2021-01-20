package com.hr180023.samet_saricicek_final.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model implements Parcelable {

    @SerializedName("index")
    @Expose
    private String index;

    @SerializedName("takim_adi")
    @Expose
    private String takim_adi;

    @SerializedName("renkler")
    @Expose
    private String renkler;

    @SerializedName("kucuk_logo")
    @Expose
    private String kucuk_logo;

    @SerializedName("buyuk_logo")
    @Expose
    private String buyuk_logo;

    @SerializedName("takim_tarih")
    @Expose
    private String takim_tarih;

    public Model(String index, String takim_adi, String renkler, String kucuk_logo, String buyuk_logo, String takim_tarih) {
        this.index = index;
        this.takim_adi = takim_adi;
        this.renkler = renkler;
        this.kucuk_logo = kucuk_logo;
        this.buyuk_logo = buyuk_logo;
        this.takim_tarih = takim_tarih;
    }

    protected Model(Parcel in) {
        index = in.readString();
        takim_adi = in.readString();
        renkler = in.readString();
        kucuk_logo = in.readString();
        buyuk_logo = in.readString();
        takim_tarih = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(index);
        dest.writeString(takim_adi);
        dest.writeString(renkler);
        dest.writeString(kucuk_logo);
        dest.writeString(buyuk_logo);
        dest.writeString(takim_tarih);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getTakim_adi() {
        return takim_adi;
    }

    public void setTakim_adi(String takim_adi) {
        this.takim_adi = takim_adi;
    }

    public String getRenkler() {
        return renkler;
    }

    public void setRenkler(String renkler) {
        this.renkler = renkler;
    }

    public String getKucuk_logo() {
        return kucuk_logo;
    }

    public void setKucuk_logo(String kucuk_logo) {
        this.kucuk_logo = kucuk_logo;
    }

    public String getBuyuk_logo() {
        return buyuk_logo;
    }

    public void setBuyuk_logo(String buyuk_logo) {
        this.buyuk_logo = buyuk_logo;
    }

    public String getTakim_tarih() {
        return takim_tarih;
    }

    public void setTakim_tarih(String takim_tarih) {
        this.takim_tarih = takim_tarih;
    }
}
