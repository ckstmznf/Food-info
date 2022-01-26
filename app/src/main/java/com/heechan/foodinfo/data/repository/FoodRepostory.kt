package com.heechan.foodinfo.data.repository

import com.heechan.foodinfo.data.model.FoodRequest
import com.heechan.foodinfo.data.model.FoodResponse
import retrofit2.Response

interface FoodRepostory {
    suspend fun getFood(foodRequest: FoodRequest) : Response<FoodResponse>
}