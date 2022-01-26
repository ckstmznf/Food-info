package com.heechan.foodinfo.ui.onBoard

import android.os.Bundle
import com.heechan.foodinfo.R
import com.heechan.foodinfo.base.BaseFragment
import com.heechan.foodinfo.data.model.OnBoard
import com.heechan.foodinfo.databinding.FragmentOnBoardBinding

class OnBoardFragment : BaseFragment<FragmentOnBoardBinding>(R.layout.fragment_on_board) {

    companion object{
        private const val KEY_ONBOARD = "onboard"

        @JvmStatic
        fun newInstance(onBoard : OnBoard) = OnBoardFragment().apply {
            arguments = Bundle().apply {
                putSerializable(KEY_ONBOARD, onBoard)
            }
        }
    }

    override fun init() {
        arguments?.let {
            binding.onBoard = it.getSerializable(KEY_ONBOARD) as OnBoard
        }
    }
}