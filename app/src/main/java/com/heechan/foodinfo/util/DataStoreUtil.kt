package com.heechan.foodinfo.util

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "datastore")

class DataStoreUtil(appContext: Context) {
    companion object {
        val KEY_FIRST_LAUNCH = booleanPreferencesKey("first_launch") //DataStore에 앱 처음 실행 여부를 저장할 키
    }

    val isFirstLaunch : Flow<Boolean> = appContext.dataStore.data.map { preference ->
        preference[KEY_FIRST_LAUNCH] ?: true
    }

    suspend fun afterFirstLaunch(context: Context){
        //처음 실행된 후 데이터스토어를 수정하는 함수

        context.dataStore.edit { preference ->
            preference[KEY_FIRST_LAUNCH] = false
        }
    }
}