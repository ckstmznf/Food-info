package com.heechan.foodinfo.ui.onBoard

import android.webkit.ValueCallback
import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2

@BindingAdapter("bindViewPagerCallBack")
fun bindViewPagerCallBack(pager : ViewPager2, callback: ViewPager2.OnPageChangeCallback){
    pager.registerOnPageChangeCallback(callback)
}