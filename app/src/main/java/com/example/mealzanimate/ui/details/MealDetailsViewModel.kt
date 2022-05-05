package com.example.mealzanimate.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mealzanimate.model.MealsRepository
import com.example.mealzanimate.model.response.MealResponse

class MealDetailsViewModel(
    private val savedStateHandler: SavedStateHandle,
): ViewModel() {
    private val repository: MealsRepository = MealsRepository.getInstance()
    var mealState = mutableStateOf<MealResponse?>(null)

    init {
        val mealId = savedStateHandler.get<String>("meal_category_id") ?: ""
        mealState.value = repository.getMeal(mealId)
    }


}