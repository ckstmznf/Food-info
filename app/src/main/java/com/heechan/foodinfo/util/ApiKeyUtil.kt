package com.heechan.foodinfo.util

import com.heechan.foodinfo.BuildConfig
import retrofit2.http.Url
import java.net.URLDecoder

object ApiKeyUtil {
    fun getApiKey() : String{
        return URLDecoder.decode(BuildConfig.API_KEY, "utf-8")
    }
}