package com.heechan.foodinfo.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<D : ViewDataBinding>(
    @LayoutRes //LayoutRes가 들어가야 한다고 알려준다.
    private val layoutResId : Int) : AppCompatActivity() {

        protected lateinit var binding : D
        //protected는 상속받은 클래스에서만 사용할 수 있다.

    protected var beforeSetContentView = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        beforeSetContentView()

        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this
    }

}