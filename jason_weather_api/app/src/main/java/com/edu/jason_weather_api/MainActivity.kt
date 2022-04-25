package com.edu.jason_weather_api
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    class Downloadjson : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg p0: String?): String {
            var result :String?=null
            val url:URL
            val kttp:HttpURLConnection?
            try {
                url= URL(p0[0])
                kttp= url.openConnection() as HttpURLConnection
                var x :InputStream=kttp.inputStream
                var y = InputStreamReader(x)
                var data :Int=y.read()
                while (data!=-1){
                    var cha=data.toChar()
                    result +=cha
                    data=y.read()
                }
                return result.toString()
            }catch (e: Exception){
                e.printStackTrace()
                return "dasd"
            }
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Log.i("json",result.toString())
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val x1=Downloadjson()
        x1.execute("https://samples.openweathermap.org")
    }
}