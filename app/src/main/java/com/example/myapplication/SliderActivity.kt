package com.example.myapplication

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_slider.*


class SliderActivity : AppCompatActivity() {

    lateinit var imageList:ArrayList<Int>

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)
        setItems()
        setPager()

    }

    private fun setItems(){
        imageList = ArrayList()
        imageList.add(R.drawable.sports1)
        imageList.add(R.drawable.sports2)
        imageList.add(R.drawable.sports1)
        imageList.add(R.drawable.sports2)

    }

    private fun setPager(){
        val customPagerAdapter=CustomPagerAdapter(this,imageList)
        viewPager.offscreenPageLimit=customPagerAdapter.count-1
        viewPager.adapter=customPagerAdapter

//        viewPager.clipToPadding=false
//        val displayMetrics = DisplayMetrics()
//        windowManager.defaultDisplay.getMetrics(displayMetrics)
//        val width = displayMetrics.widthPixels
//        val paddingToSet = width / 8
//        viewPager.setPadding(0, 0, paddingToSet, 0)

        viewPager.clipToPadding=false
        viewPager.setPadding(100, 0, 100, 0)
        viewPager.pageMargin=20
        viewPager.setPageTransformer(false, ViewPager.PageTransformer { page, _ ->
            if (viewPager.currentItem == 0) {
                page.translationX = -120f
            } else if (viewPager.currentItem == customPagerAdapter.count - 1) {
                page.translationX = 120f

            } else {
                page.translationX = 0f
            }
        })


    }

    private fun setFacebookPage(){
//        buttonNext.setOnClickListener {
//            webView = (WebView) findViewById(R.id.webView1);
//            webView.getSettings().setJavaScriptEnabled(true);
//            webView.loadUrl("http://www.google.com");


        }

    }



