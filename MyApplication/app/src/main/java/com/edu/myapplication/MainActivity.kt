@file:Suppress("DEPRECATION", "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.edu.myapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.net.HttpURLConnection
import java.net.URL
import java.util.regex.Pattern
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStreamReader
import java.lang.Exception

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private var itemn=ArrayList<String>()
    private var im=ArrayList<String>()
    fun img(View: View){
        val cc=Myimg()
        val img:Bitmap
val po=spinner.selectedItemPosition
        try {
            img=cc.execute(im[po]).get()
            imageView.setImageBitmap(img)
        }catch (e:Exception){
            e.printStackTrace()
        }

    }
    fun gogo(v: View) {
        spinner.visibility=View.VISIBLE
    }
    class STR:AsyncTask<String,Void,String>(){
        override fun doInBackground(vararg p0: String?): String {
            var res=""
            val url:URL
            val urlConn: HttpURLConnection
            try {
                url= URL(p0[0])
                urlConn= url.openConnection() as HttpURLConnection
                val inn =urlConn.inputStream
                val read1 = InputStreamReader(inn)
                var data=read1.read()
                while (data!=-1){
                    val cuur:Char=data.toChar()
                    res+=cuur
                    data=read1.read()
                }
                return res
            }
            catch (e :Exception){
                e.printStackTrace()
                return "failed"
            }
        }

    }
    class Myimg : AsyncTask<String, Void, Bitmap>(){
        override fun doInBackground(vararg p0: String?): Bitmap? {
           try {
               val url =URL(p0[0])
               val h :HttpURLConnection=url.openConnection() as HttpURLConnection
               h.connect()
               val inn = h.inputStream
               val bit = BitmapFactory.decodeStream(inn)
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
        spinner.visibility=View.INVISIBLE
        var ress =""
        val ss=STR()
        try{
            ress=ss.execute("http://www.posh24.se/kandisar").get()
        }catch (e:Exception){
            e.printStackTrace()
        }
        val aadd =ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itemn)

        var pp=Pattern.compile("alt=\"(.*?)\"")
        var mm=pp.matcher(ress as CharSequence)

        while (mm.find()){
            aadd.add(mm.group(1))
            Log.i("/////////////////","name in")
        }
        pp=Pattern.compile("<img src=\"(.*?)\"")
        mm=pp.matcher(ress as CharSequence)
        while (mm.find()){
            im.add(mm.group(1))
            Log.i(".................","pic in")
        }
        spinner?.adapter= aadd
    }
}