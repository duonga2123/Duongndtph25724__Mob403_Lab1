package com.example.slide1androidnetworking;

import android.graphics.Bitmap;

public interface Listener{
    void onImageLoaded(Bitmap bitmap);
    void onError();
}
