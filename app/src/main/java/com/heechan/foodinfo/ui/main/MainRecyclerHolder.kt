package com.heechan.foodinfo.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.heechan.foodinfo.data.model.Food
import com.heechan.foodinfo.databinding.RowFoodBinding
import com.heechan.foodinfo.ui.Food.FoodActivity

class MainRecyclerHolder(private val binding : RowFoodBinding) : RecyclerView.ViewHolder(binding.root) {
    constructor(parent: ViewGroup) : this(
        RowFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    init{
        binding.root.setOnClickListener {
            it.context.run {
                val intent = Intent(this, FoodActivity::class.java).apply {
                    putExtra("food", binding.food)
                }
                startActivity(intent)
            }
        }
    }

    fun bind(food : Food){
        binding.food = food
    }
}