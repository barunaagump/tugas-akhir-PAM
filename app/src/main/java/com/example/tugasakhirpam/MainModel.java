package com.example.tugasakhirpam;

public class MainModel {

    String Judul,Murl,Rating,Review;

    MainModel()
    {

    }

    public MainModel(String judul, String murl, String rating, String review) {
        Judul = judul;
        Murl = murl;
        Rating = rating;
        Review = review;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public String getMurl() {
        return Murl;
    }

    public void setMurl(String murl) {
        Murl = murl;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }
}
