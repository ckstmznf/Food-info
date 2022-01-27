package com.heechan.foodinfo.ui.Food

import android.os.Bundle
import com.heechan.foodinfo.R
import com.heechan.foodinfo.base.BaseFragment
import com.heechan.foodinfo.databinding.FragmentFoodImgBinding

class FoodImgFragment : BaseFragment<FragmentFoodImgBinding>(R.layout.fragment_food_img) {

    companion object {
        private const val KEY_IMAGE_LINK = "imgLink"

        @JvmStatic
        fun newInstance(imgUrl : String) = FoodImgFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_IMAGE_LINK, imgUrl)
            }
        }
    }

    override fun init() {
        arguments?.let{
            binding.imgUrl = it.getString(KEY_IMAGE_LINK)
        }
    }
}