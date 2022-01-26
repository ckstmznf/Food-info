package com.heechan.foodinfo.data.remote

import com.heechan.foodinfo.data.model.FoodResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodService {
    @GET("/B553748/CertImgListService/getCertImgListService")
    suspend fun getFoods(
        @Query("ServiceKey") ServiceKey: String?,
        @Query("prdlstReportNo") prdlstReportNo: String?,
        @Query("prdlstNm") prdlstNm: String?,
        @Query("returnType") returnType: String?,
        @Query("pageNo") pageNo: String?,
        @Query("numOfRows") numOfRows: String?
    ): Response<FoodResponse> //Call과 동일한테 코루틴을 사용할때 더 편하다.


}