package com.heechan.foodinfo.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.heechan.foodinfo.R
import com.heechan.foodinfo.base.BaseActivity
import com.heechan.foodinfo.databinding.ActivityMainBinding
import com.heechan.foodinfo.ui.onBoard.OnBoardActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
//        beforeSetContentView = {
//            installSplashScreen()
//            //스플레시 화면을 보여준다.
//        }

        installSplashScreen()
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        binding.button.setOnClickListener{
            val intent = Intent(this, OnBoardActivity::class.java)
            startActivity(intent)
        }
    }
}