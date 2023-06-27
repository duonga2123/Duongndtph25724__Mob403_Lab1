package com.example.slide1androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img;
    private Button btn;
    private ProgressDialog progressDialog;
    private String url = "https://upload.wikimedia.org/wikipedia/commons/2/20/FPT_Polytechnic.png";
    private Bitmap bitmap = null;
    private TextView tvMess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);
        btn = findViewById(R.id.btn);
        tvMess = findViewById(R.id.message);
        btn.setOnClickListener(this);
    }

    private Handler messageHandler = new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String mess = bundle.getString("mess");
            tvMess.setText(mess);
            img.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    };

    @Override
    public void onClick(View view) {
        progressDialog = ProgressDialog.show(MainActivity.this, "", "Downloading...");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                bitmap = downloadBitmap(url);
                Message msg = messageHandler.obtainMessage();
                Bundle bundle = new Bundle();
                String threadMessage = "Image downloaded";
                bundle.putString("mess", threadMessage);
                msg.setData(bundle);
                messageHandler.sendMessage(msg);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private Bitmap downloadBitmap(String link){
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public interface Listener{
        void onImageLoaded(Bitmap bitmap);
        void onError();
    }

}