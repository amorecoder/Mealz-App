package com.example.mealzanimate.model.response

import com.google.gson.annotations.SerializedName

// these data classes are for conversion of JSon to our desired data structure

data class MealsCategoriesResponse(
    val categories: List<MealResponse> // not using @SerializeName here cos we using same field name as in JSon
)

// use GSon library to map and transform JSon data to our data class
data class MealResponse(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)

