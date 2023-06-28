package com.example.slide1androidnetworking;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Bai4 extends AsyncTask<String, String, String> {
    private String resp;
    ProgressDialog dialog;
    TextView tv;
    EditText time;
    Context context;

    public Bai4(Context context, TextView tv, EditText time) {
        this.tv = tv;
        this.context = context;
        this.time = time;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = ProgressDialog.show(context, "ProgressDialog", "Wait for "
                + time.getText().toString() + " seconds");
    }

    @Override
    protected String doInBackground(String... params) {
        publishProgress("Sleeping...");
        try {
            int time = Integer.parseInt(params[0]) * 1000;
            Thread.sleep(time);
            resp = "Slept for " + params[0] + " seconds";
        } catch (Exception e) {
            e.printStackTrace();
            resp = e.getMessage();
        }
        return resp;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (dialog.isShowing()) {
            dialog.dismiss();
            tv.setText(result);
        }
    }


}