package com.example.slide1androidnetworking;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Bai3 extends AsyncTask<String, Void, Bitmap>{
    private Listener mListener;
    private ProgressDialog progressDialog;
    public Bai3(Listener listener, Context context) {

        mListener = listener;
        progressDialog = new ProgressDialog(context);
    }
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("Downloading image..");
            progressDialog.show();

        }



    @Override
    protected Bitmap doInBackground (String... params) {
        try {
            return BitmapFactory.decodeStream((InputStream) new URL(params[0]).getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
        @Override
        protected void onPostExecute (Bitmap result) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            if (result != null) {
                mListener.onImageLoaded(result);
            } else {
                mListener.onError();
            }
        }
}