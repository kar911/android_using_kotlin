package com.edu.project1

import android.os.AsyncTask
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class down : AsyncTask<String?, Unit?, String>() {
    override fun doInBackground(vararg p0: String?): String? {
        var res:String=""
        var url: URL
        var urlConn: HttpURLConnection
        try {
            url= URL(p0[0])
            urlConn= url.openConnection() as HttpURLConnection
            var inn: InputStream =urlConn.inputStream
            var read1: InputStreamReader = InputStreamReader(inn)
            var data=read1.read()
            while (data!=-1){
                var cuur:Char=data as Char

                res+=cuur
                data=read1.read()
            }
            return res
        }
        catch (e :java.lang.Exception){
            e.printStackTrace()
            return "failed"
        }


    }
}