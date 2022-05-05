package com.example.mealzanimate.ui.meals

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealzanimate.model.MealsRepository
import com.example.mealzanimate.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

// view model class must inherit from ViewModel to be bind to android lifecycle
// our ViewModel has an instance of our repository
class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository.getInstance()) : ViewModel() {

    // no longer need to use remember since mealsState will live as long as this ViewModel lives.
    val mealsState = mutableStateOf(emptyList<MealResponse>())

    // launching coroutine during init using viewModelScope() which will auto destroy when view model is out of scope/destroyed.
    private val mealsJob = Job()
    init {
        Log.d("TAG_COROUTINES", "we are abouut to launch a coroutine") //1
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("TAG_COROUTINES", "we have launched the coroutine") //3
            val meals = getMeals()
            Log.d("TAG_COROUTINES", "we have received the async data") //4
            mealsState.value = meals
        }
        Log.d("TAG_COROUTINES", "other work...") //2
    }

    // this can be set as private since we not querying data from view
    private suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }

}