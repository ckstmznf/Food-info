package com.heechan.foodinfo.ui.main

import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.heechan.foodinfo.data.model.Food
import com.heechan.foodinfo.util.Status

@BindingAdapter("bindFoods")
fun bindFoods(recyclerView: RecyclerView, foods : ObservableArrayList<Food>?){
    val adapter = recyclerView.adapter as MainRecyclerAdapter? ?: return

    if(foods != null) adapter.submitList(foods.toMutableList())
    //ListADapter에는 submitList 메서드가 있다.
}

@BindingAdapter("bindSwipeOnRefresh")
fun bindSwipeOnRefresh(swiperRefresh : SwipeRefreshLayout, status : Status?){
    if(status != null) swiperRefresh.isRefreshing = (status == Status.LOADING)
    // swiperRefresh.isRefreshing는 로딩중임을 표시 한다.
}

@BindingAdapter("bindSwipeOnRefresh")
fun bindSwipeOnRefresh(swiperRefresh : SwipeRefreshLayout, job : () -> Unit){
    swiperRefresh.setOnRefreshListener(job)
}

@BindingAdapter("bindSwipeRefreshing")
fun bindSwipeRefreshing(swipeRefresh: SwipeRefreshLayout, status: Status?) {
    if (status != null) swipeRefresh.isRefreshing = (status == Status.LOADING)
}

@BindingAdapter("bindDoAfterTextChanged")
fun bindDoAfterTextChanged(editText: EditText, job : () -> Unit){
    editText.doAfterTextChanged{ job() } //텍스트가 변경됐을때 실행 한다.
}

//바인딩 어댑터의 인자로 여러개를 넣어줄때 사용한다.
// requireAll은 인자를 둘다 넣워줘야 한드는 의미 이다.
@BindingAdapter(value = ["bindRecyclerOnScrollEnd", "bindRecyclerTotalItem"], requireAll = true)
fun bindRecyclerOnScrollEnd(recycler: RecyclerView, job: () -> Unit, total: Int) {
    val layoutManager = recycler.layoutManager as GridLayoutManager? ?: return

    recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val visibleItemCount = layoutManager.childCount
            val totalItemCount = layoutManager.itemCount
            val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

            if (visibleItemCount + firstVisibleItemPosition >= totalItemCount
                && firstVisibleItemPosition >= 0
                && totalItemCount >= total
            ) job()
        }
    })
}