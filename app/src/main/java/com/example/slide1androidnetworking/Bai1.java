package com.example.slide1androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Bai1 extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    ImageView img;
    TextView tvmess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        btn = findViewById(R.id.btn);
        img = findViewById(R.id.img);
        tvmess = findViewById(R.id.message);
        btn.setOnClickListener(this);

    }

    private Bitmap loadImageFromNetwork(String link){
        URL url;
        Bitmap bmp = null;
        try {
            url = new URL(link);
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmp;
    }

    @Override
    public void onClick(View view) {
        final Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = loadImageFromNetwork("https://upload.wikimedia.org/wikipedia/commons/2/20/FPT_Polytechnic.png");
                img.post(new Runnable() {
                    @Override
                    public void run() {
                        tvmess.setText("Image Downloaded");
                        img.setImageBitmap(bitmap);
                        Toast.makeText(Bai1.this, "Heheh", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        myThread.start();
    }
}