package com.example.mealzanimate.model

import com.example.mealzanimate.model.api.MealsWebService
import com.example.mealzanimate.model.response.MealResponse
import com.example.mealzanimate.model.response.MealsCategoriesResponse

// our model class gets data from data provider via our MealsWebService object
class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    private var cachedMeals = listOf<MealResponse>()

    suspend fun getMeals(): MealsCategoriesResponse {
        val response = webService.getMeals()
        cachedMeals = response.categories
        return response
    }

    fun getMeal(id: String): MealResponse? {
        return cachedMeals.firstOrNull { it.id == id }
    }

    // define our class as a singleton
    companion object {
        @Volatile
        private var instance: MealsRepository? = null

        fun getInstance() = instance?: synchronized(this) {
            instance ?: MealsRepository().also { instance = it }
        }
    }
}