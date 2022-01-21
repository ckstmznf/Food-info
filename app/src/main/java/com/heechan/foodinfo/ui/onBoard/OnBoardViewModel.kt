package com.heechan.foodinfo.ui.onBoard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.viewpager2.widget.ViewPager2

class OnBoardViewModel : ViewModel() {
    private val _currentPage = MutableLiveData(0)
    val currentPage : LiveData<Int>
        get() = _currentPage


    val pagerCallBack : ViewPager2.OnPageChangeCallback = object : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            _currentPage.value = position
        } //뷰패이지의 페이지가 변겨오딜때마다 실행되는 콜백 함수
    }
}