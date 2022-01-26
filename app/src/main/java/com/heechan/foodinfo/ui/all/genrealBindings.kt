package com.heechan.foodinfo.ui.all

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

@BindingConversion
fun convertBooleanToVisible(visible : Boolean) : Int{
    return if(visible) View.VISIBLE else View.GONE
}

@BindingAdapter("bindingInvisible")
fun bindingInvisible(v : View, b : Boolean){
    v.visibility = if(b) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("bindingLottieUrl")
fun bindingLottieUrl(v : LottieAnimationView, url : String?){
    if(url.isNullOrEmpty()) return

    v.setAnimationFromUrl(url)
}

@BindingAdapter("bindTapLayoutMediator")
fun bindTapLayoutMediator(tabLayout: TabLayout, pager : ViewPager2){
    if(pager.adapter == null) return

    TabLayoutMediator(tabLayout, pager){ tab : TabLayout.Tab, _ ->
//        tab.view.isClickable = false
//        tab.view.isFocusable = false

        tab.view.run {
            isClickable = false
            isFocusable = false
        }
    }.attach()
}

@BindingAdapter("bindImageUrl")
fun bindImageUrl(imgView : ImageView, url : String?){
    if(url.isNullOrEmpty()) return

    Glide.with(imgView).load(url).into(imgView)
}