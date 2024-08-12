package com.example.giminitest

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.giminitest.data.json.situation.s1.tmp.S1enItem
import com.example.giminitest.ui.page.main.SearchPage
import com.example.giminitest.ui.page.main.TripPage

@Composable
fun Navigation(modifier: Modifier = Modifier) {

    var route by remember {
        mutableStateOf<Route>(Route.Search)
    }

    AnimatedContent(
        route,
        label = "",
        modifier = modifier,
        transitionSpec = { (fadeIn().togetherWith(fadeOut())) }) {
        when (it) {
            Route.Search -> SearchPage(
                navigateToTrip = { newRoute -> route = newRoute },
            )

            is Route.Trip -> {
                TripPage(it)
            }
        }
    }
}

@Composable
private fun extracted() {
    TODO()
}

sealed class Route {
    data object Search: Route()
    data class Trip(val id: String, val s1: List<S1enItem>): Route()
}