package com.example.voice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var friends= arrayListOf<String>()
        button7.setOnClickListener {
            friends.add(textviewtoadd.text.toString())
        }
        var arra=ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,friends)
        mylistview.adapter=arra
        mylistview.setOnItemClickListener(object :AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@MainActivity,friends[p2],Toast.LENGTH_SHORT).show()
            }

        })
    }
}

//        val listname = arrayListOf<String>("kar","tik","moy","ade","kar","tik","moy","ade","kar","tik","moy","ade")
//        button7.setOnClickListener {
//            var item:String=textviewtoadd.text.toString()
//            listname.add(item)
//        }
//        var arra=ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,listname)
//
//        mylistview.adapter=arra
//        mylistview.setOnItemClickListener(object :AdapterView.OnItemClickListener{
//            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                Toast.makeText(this@MainActivity, listname[p2],Toast.LENGTH_SHORT).show()
//            }
//        })