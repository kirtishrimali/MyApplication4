package com.example.myapplication

import android.content.Context
import android.support.constraint.ConstraintLayout

import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.v4.view.PagerAdapter
import android.view.View
import android.widget.ImageView

class CustomPagerAdapter(context:Context,imageList:ArrayList<Int>):PagerAdapter() {

    var mContext:Context = context
    private var imageList=imageList

    var mLayoutInflater:LayoutInflater

    init{
        mLayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
    override fun isViewFromObject(view:View, `object`:Any):Boolean {
        return view === (`object` as ConstraintLayout)
    }
    override fun instantiateItem(container:ViewGroup, position:Int):Any {

        val view=mLayoutInflater.inflate(R.layout.custompager_layout,container,false)
        val imageView = view.findViewById(R.id.imageviewSlider) as RoundedImageView

        imageView.setImageResource(imageList[position])
        container.addView(view)
        return view
    }
    override fun destroyItem(container:ViewGroup, position:Int, `object`:Any) {
        container.removeView(`object` as ConstraintLayout)
    }

    override fun getCount(): Int {
        return 4
    }

}
