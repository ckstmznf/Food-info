package com.heechan.foodinfo.ui.main

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.heechan.foodinfo.data.model.Food

class MainRecyclerAdapter : ListAdapter<Food, RecyclerView.ViewHolder>(MainDiffUtilCallBack()){

    class MainDiffUtilCallBack : DiffUtil.ItemCallback<Food>(){
        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
            //두 아이템이 같은지 다른지 비교한다.
            return oldItem.prdlstReportNo == newItem.prdlstReportNo
        }

        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MainRecyclerHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MainRecyclerHolder).bind(getItem(position))
    }

}