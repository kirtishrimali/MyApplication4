package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSlider.setOnClickListener(this)
        buttonReference.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v==btnSlider){
            val intent=Intent(this,SliderActivity::class.java)
            startActivity(intent)
        }
        if (v==buttonReference){
            val intent=Intent(this,ReferenceActivity::class.java)
            startActivity(intent)

        }
    }
}
