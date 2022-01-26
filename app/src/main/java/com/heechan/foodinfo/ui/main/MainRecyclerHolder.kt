package com.heechan.foodinfo.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.heechan.foodinfo.data.model.Food
import com.heechan.foodinfo.databinding.RowFoodBinding

class MainRecyclerHolder(private val binding : RowFoodBinding) : RecyclerView.ViewHolder(binding.root) {
    constructor(parent: ViewGroup) : this(
        RowFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    init{

    }

    fun bind(food : Food){
        binding.food = food
    }
}