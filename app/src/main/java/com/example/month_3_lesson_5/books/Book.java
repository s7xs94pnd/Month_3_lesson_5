package com.example.month_3_lesson_5.books;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Book implements Parcelable {
    private String name,desc,ganr;
    private int img;
    private double score;
    private boolean fav;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getGanr() {
        return ganr;
    }

    public void setGanr(String ganr) {
        this.ganr = ganr;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }

    public Book(String name, String desc, String ganr, int img, double score, boolean fav) {
        this.name = name;
        this.desc = desc;
        this.ganr = ganr;
        this.img = img;
        this.score = score;
        this.fav = fav;
    }

    protected Book(Parcel in) {
        name = in.readString();
        desc = in.readString();
        ganr = in.readString();
        img = in.readInt();
        score = in.readDouble();
        fav = in.readByte() != 0;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(desc);
        parcel.writeString(ganr);
        parcel.writeInt(img);
        parcel.writeDouble(score);
        parcel.writeByte((byte) (fav ? 1 : 0));
    }
}

