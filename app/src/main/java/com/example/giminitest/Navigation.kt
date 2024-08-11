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
import com.example.giminitest.data.json.situation.s1.tmp.S1en
import com.example.giminitest.data.json.situation.s1.tmp.S1enItem
import com.example.giminitest.ui.page.main.PlanPage
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
                navigateToPlan = { newRoute -> route = newRoute },
                navigateToTrip = { newRoute -> route = newRoute },
            )
//            Route.SEARCH -> ConversationPage(
//                navigate = { route = Route.PLAN }
//            )
            is Route.Plan -> PlanPage(
                navigate = { route = Route.Search },
                planState = it.planS1
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
    data class Plan(val planS1: PlanState): Route() {
        sealed class PlanState {
            data class PlanS1(val s1: List<S1enItem>): PlanState()
        }

        companion object {
            val fake = PlanState.PlanS1(S1en.getList())
        }
    }
    data class Trip(val id: String, val s1: List<S1enItem>): Route() {
//        sealed class TripState {
//            data class TripS1(val s1: List<S1enItem>): TripState()
//        }

        companion object {
//            val fake = TripState.TripS1(S1en.getList())
//            val fake2 = TripState.TripS1(S1en.getList2())
//            val fake3 = TripState.TripS1(S1en.getList2())
        }
    }
}