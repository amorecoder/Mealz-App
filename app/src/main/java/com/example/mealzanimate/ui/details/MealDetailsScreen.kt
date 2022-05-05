package com.example.mealzanimate.ui.details

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.mealzanimate.model.response.MealResponse
import java.lang.Float.min

@Composable
fun MealDetailsScreen(meal: MealResponse?) {

    val scrollState = rememberScrollState()
    val offset = min(1f, 1 - (scrollState.value / 600f)) // for adjusting image size as user scroll content
    val size by animateDpAsState(targetValue = max(100.dp, 200.dp * offset)) // size varies from 100dp to adjusted size during scrolling up to max of 200dp.

    Surface(color = MaterialTheme.colors.background) {
        Column() {
            Surface(elevation = 4.dp) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(
                        modifier = Modifier.padding(16.dp),
                        shape = CircleShape,
                        border = BorderStroke(width = 2.dp, color = Color.Green)
                    ) {
                        Image(
                            painter = rememberImagePainter(
                                        data = meal?.imageUrl,
                                        builder = { transformations(CircleCropTransformation()) }
                                    ),
                            contentDescription = null,
                            modifier = Modifier.size(size)
                        )
                    }

                    Text(
                        text = meal?.name?: "default name",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }

            Column(modifier = Modifier.verticalScroll(scrollState)) {
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
            }
        }
    }
}

enum class MealProfilePictureState(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(Color.Magenta, 120.dp, 8.dp),
    Expanded(Color.Black, 200.dp, 24.dp),
}