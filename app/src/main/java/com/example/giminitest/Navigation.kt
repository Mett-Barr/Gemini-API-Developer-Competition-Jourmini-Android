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
import com.example.giminitest.ui.page.main.PlanPage
import com.example.giminitest.ui.page.main.SearchPage

@Composable
fun Navigation(modifier: Modifier = Modifier) {

    var route by remember {
        mutableStateOf(Route.SEARCH)
    }

    AnimatedContent(
        route,
        label = "",
        modifier = modifier,
        transitionSpec = { (fadeIn().togetherWith(fadeOut())) }) {
        when (it) {
            Route.SEARCH -> SearchPage(
                navigate = { route = Route.PLAN }
            )
            Route.PLAN -> PlanPage(
                navigate = { route = Route.SEARCH }
            )
        }
    }
}

enum class Route {
    SEARCH,
    PLAN
}