package com.edu.project1;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class wingman extends AppCompatActivity {
    public class down extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            Log.i("sads",strings[0]);
            return "good";
        }
    }
}
