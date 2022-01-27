package com.heechan.foodinfo.ui.main

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.heechan.foodinfo.data.model.Food
import com.heechan.foodinfo.data.model.FoodRequest
import com.heechan.foodinfo.data.model.FoodResponse
import com.heechan.foodinfo.data.repository.FoodRepositoryImpl
import com.heechan.foodinfo.util.ApiKeyUtil
import com.heechan.foodinfo.util.Resource
import com.heechan.foodinfo.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val foodRepostory: FoodRepositoryImpl): ViewModel() {
    private val _result = MutableLiveData<Resource<FoodResponse>>(Resource.loading())
    val result : LiveData<Resource<FoodResponse>>
        get() = _result

    val searchText = MutableLiveData("")

    val foodList = ObservableArrayList<Food>()
    // 관찰할 수 있는 array list
    // LiveData를 사용하면 리스트 안의 값이 변경되는건 감지를 못한다.

    private var _itemsPerPage = 20
    val itemsPerPage : Int
        get() = _itemsPerPage
        //한페이지에 보여주는 아이템 개수

    private var currentPage = 1 //현재 보고있는 페이지의 번호

    init {
        getFood()
    }

    private fun getFood(){
        //값을 가져와서 리스트를 갱신해준다.
        val foodRequest = FoodRequest(
            ServiceKey = ApiKeyUtil.getApiKey(),
            prdlstNm = searchText.value,
            pageNo = currentPage.toString(),
            numOfRows = itemsPerPage.toString()
        )

        viewModelScope.launch(CoroutineExceptionHandler{_, e  -> //viewModelScpoe에서 에러가 났을때 실행
            _result.value = Resource.error(e.stackTraceToString(), null)
        }) {
            _result.value = Resource.loading()
            val response = withContext(Dispatchers.IO){
                foodRepostory.getFood(foodRequest)
            }

            if(response.isSuccessful){ //가져온 데이터가 성공이다.
                val body = response.body() ?: return@launch //가져온 데이터의 아이템을 가져온다
                if(body.resultCode != "OK"){ //가져온 데이터의 성공 여부
                    _result.value = Resource.error(body.resultMessage, body) //
                    return@launch
                }

                _result.value = Resource.success(body)
                if(currentPage == 1) foodList.clear() //계속 새로고침을 하면 같은 갑이 들어가니까 리스트를 비워준다.
                foodList.addAll(body.list)
            }   else _result.value = Resource.error(response.errorBody().toString(), null)
        }
        //viewModelScope는 viewmodel이 제거될때 없어진다.
    }

    fun refreshFoods(){
        currentPage = 1
        getFood()
    }

    fun getMoreFoods(){
        if(result.value!!.status == Status.LOADING) return

        currentPage++
        getFood()
    }


}