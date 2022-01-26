package com.heechan.foodinfo.data.repository

import com.heechan.foodinfo.data.model.FoodRequest
import com.heechan.foodinfo.data.model.FoodResponse
import com.heechan.foodinfo.data.remote.FoodService
import retrofit2.Response
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(private val foodService: FoodService) : FoodRepostory{

    override suspend fun getFood(foodRequest: FoodRequest): Response<FoodResponse> {
        return foodService.getFoods(
            ServiceKey = foodRequest.ServiceKey,
            prdlstReportNo = foodRequest.prdlstReportNo,
            prdlstNm = foodRequest.prdlstNm,
            returnType = foodRequest.returnType,
            pageNo = foodRequest.pageNo,
            numOfRows = foodRequest.numOfRows
        )
    }
}