@file:JvmName("First")

package com.edu.project1

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
fun downlod(View: View){
var Task=MyAsyncTask()
  var img:Bitmap
    try {
        img=Task.execute("https://cdn2.vectorstock.com/i/1000x1000/94/96/the-cute-colored-butterfly-on-the-grass-vector-8959496.jpg").get()
        imageView.setImageBitmap(img)
    }catch (e :Exception){
        e.printStackTrace()
    }
}

    class MyAsyncTask : AsyncTask<String, Void, Bitmap>() {
        override fun doInBackground(vararg p0: String?): Bitmap? {
            try {
                var url: URL = URL(p0[0])
                var conn: HttpURLConnection = url.openConnection() as HttpURLConnection
                conn.connect()
                var inn: InputStream = conn.inputStream

                var bit: Bitmap = BitmapFactory.decodeStream(inn)
                return bit
            } catch (e: Exception) {
                e.printStackTrace()
                return null
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}