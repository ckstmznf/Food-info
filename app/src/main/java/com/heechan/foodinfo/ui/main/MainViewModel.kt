package com.heechan.foodinfo.ui.main

import androidx.lifecycle.ViewModel
import com.heechan.foodinfo.data.repository.FoodRepositoryImpl
import com.heechan.foodinfo.data.repository.FoodRepostory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val foodRepostory: FoodRepositoryImpl): ViewModel() {

}