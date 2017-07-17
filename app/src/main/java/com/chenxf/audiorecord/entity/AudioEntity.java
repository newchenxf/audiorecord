package com.chenxf.audiorecord.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class AudioEntity implements Parcelable,Serializable {
    private String url;
    private long duration;

    public String getUrl() {
        return url;
    }

    public long getDuration() {
        return duration;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeLong(this.duration);
    }

    public AudioEntity() {
    }

    protected AudioEntity(Parcel in) {
        this.url = in.readString();
        this.duration = in.readLong();
    }

    public static final Creator<AudioEntity> CREATOR =
            new Creator<AudioEntity>() {
                @Override
                public AudioEntity createFromParcel(Parcel source) {
                    return new AudioEntity(source);
                }

                @Override
                public AudioEntity[] newArray(int size) {
                    return new AudioEntity[size];
                }
            };
}
