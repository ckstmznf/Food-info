package com.heechan.foodinfo.ui.onBoard

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.heechan.foodinfo.R
import com.heechan.foodinfo.base.BaseActivity
import com.heechan.foodinfo.data.model.OnBoard
import com.heechan.foodinfo.databinding.ActivityOnBoardBinding
import com.heechan.foodinfo.ui.all.ViewPagerAdapter
import com.heechan.foodinfo.util.DataStoreUtil
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardActivity : BaseActivity<ActivityOnBoardBinding>(R.layout.activity_on_board) {
    private val viewModel : OnBoardViewModel by viewModels()

    @Inject
    lateinit var dataStore : DataStoreUtil
    //Hilt를 사용 할때는 privat객체에는 접근 할 수 없다.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        val fragments = initFragment()

        binding.maxLength = fragments.size
        binding.vpOnBoard.adapter = ViewPagerAdapter(this, fragments)
        binding.vpOnBoard.offscreenPageLimit = fragments.size - 1 //화면에 안보이는 프레그먼트도 랜더링을 해둔다.

        binding.btOnBoardSkip.setOnClickListener{
            finish()
        }

        binding.btOnBoardFinish.setOnClickListener {
            finish()
        }
    }

    override fun onBackPressed() {
        val page = viewModel.currentPage.value!!
        //뒤로 가기를 눌렀을때 실행되는 함수

        if(page == 0) super.onBackPressed()
        else binding.vpOnBoard.currentItem = page - 1
    }

    override fun finish() {
        lifecycleScope.launch {
            dataStore.afterFirstLaunch(this@OnBoardActivity)

            super.finish()
        }
    }

    private fun initFragment() : List<Fragment>{
        return listOf(
            OnBoardFragment.newInstance(
                OnBoard(getString(R.string.lottie_onboard_1), getString(R.string.onboard_title_1), getString(R.string.onboard_description_1))
            ),
            OnBoardFragment.newInstance(
                OnBoard(getString(R.string.lottie_onboard_2), getString(R.string.onboard_title_2), getString(R.string.onboard_description_2))
            ),
            OnBoardFragment.newInstance(
                OnBoard(getString(R.string.lottie_onboard_3), getString(R.string.onboard_title_1), getString(R.string.onboard_description_3))
            ),
        )
    }
}