package com.heechan.foodinfo.ui.Food

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.heechan.foodinfo.R
import com.heechan.foodinfo.base.BaseActivity
import com.heechan.foodinfo.data.model.Food
import com.heechan.foodinfo.databinding.ActivityFoodBinding
import com.heechan.foodinfo.ui.all.ViewPagerAdapter

class FoodActivity : BaseActivity<ActivityFoodBinding>(R.layout.activity_food) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val foodData = intent.getSerializableExtra("food") as Food

        binding.food = foodData

        val fragments = listOf<Fragment>(
            FoodImgFragment.newInstance(foodData.imgurl1),
            FoodImgFragment.newInstance(foodData.imgurl2),
        )

        binding.vpFood.adapter = ViewPagerAdapter(this, fragments)
        binding.vpFood.offscreenPageLimit = fragments.size - 1

        binding.toolbarFood.setNavigationOnClickListener { //Toolbar의 뒤로가기 버튼 눌렀을ㄲ때
            finish()
        }

        binding.btnFoodShare.setOnClickListener{
            shaerFood(foodData)
        }
    }

    private fun shaerFood(food : Food){
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND

            putExtra(Intent.EXTRA_TEXT, "[${food.prdlstNm}](${food.imgurl1})\n${food.rawmtrl}")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, getString(R.string.food_share))
        startActivity(shareIntent)
    }
}