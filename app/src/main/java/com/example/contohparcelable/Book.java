package com.example.contohparcelable;

import android.os.Parcel;
import android.os.Parcelable;

    public class Book implements Parcelable {
    // book basics
    private String title;
    private String author;
        // main constructor
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        protected Book(Parcel in) {
            title = in.readString();
            author = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(title);
            dest.writeString(author);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Book> CREATOR = new Creator<Book>() {
            @Override
            public Book createFromParcel(Parcel in) {
                return new Book(in);
            }

            @Override
            public Book[] newArray(int size) {
                return new Book[0];
            }
        };

        // getters
        public String getTitle() { return title; }
        public String getAuthor() { return author; }
}

