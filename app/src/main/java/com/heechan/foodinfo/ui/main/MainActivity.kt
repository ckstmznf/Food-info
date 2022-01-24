package com.heechan.foodinfo.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.asLiveData
import com.heechan.foodinfo.R
import com.heechan.foodinfo.base.BaseActivity
import com.heechan.foodinfo.databinding.ActivityMainBinding
import com.heechan.foodinfo.ui.onBoard.OnBoardActivity
import com.heechan.foodinfo.util.DataStoreUtil

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel : MainViewModel by viewModels()

    lateinit var dataStoreUtil: DataStoreUtil

    override fun onCreate(savedInstanceState: Bundle?) {
//        beforeSetContentView = {
//            installSplashScreen()
//            //스플레시 화면을 보여준다.
//        }

        installSplashScreen()
        super.onCreate(savedInstanceState)

        dataStoreUtil = DataStoreUtil(applicationContext)
        dataStoreUtil.isFirstLaunch.asLiveData().observe(this){ ifFirest ->
            if(ifFirest){

                val intent = Intent(this, OnBoardActivity::class.java)
                startActivity(intent)
            }
        }
        //Flow를 livedata로 치환을 해서 변경을 감지 한다/


        binding.viewModel = viewModel

        binding.button.setOnClickListener{
            val intent = Intent(this, OnBoardActivity::class.java)
            startActivity(intent)
        }
    }
}