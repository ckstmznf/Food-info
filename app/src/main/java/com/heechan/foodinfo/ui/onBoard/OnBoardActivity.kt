package com.heechan.foodinfo.ui.onBoard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.heechan.foodinfo.R
import com.heechan.foodinfo.base.BaseActivity
import com.heechan.foodinfo.data.OnBoard
import com.heechan.foodinfo.databinding.ActivityOnBoardBinding
import com.heechan.foodinfo.ui.all.ViewPagerAdapter

class OnBoardActivity : BaseActivity<ActivityOnBoardBinding>(R.layout.activity_on_board) {
    private val viewModel : OnBoardViewModel by viewModels()

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