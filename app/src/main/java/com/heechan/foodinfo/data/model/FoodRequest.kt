package com.heechan.foodinfo.data.model

import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class FoodRequest(
    val ServiceKey: String,
    val prdlstReportNo: String? = null,
    val prdlstNm: String?,
    val returnType: String = "json",
    val pageNo: String,
    val numOfRows: String,
) : Serializable