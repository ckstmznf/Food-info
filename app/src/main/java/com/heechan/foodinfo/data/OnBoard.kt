package com.heechan.foodinfo.data

import java.io.Serializable

data class OnBoard(
    val lottieUrl : String,
    val title : String,
    val description : String,
) : Serializable