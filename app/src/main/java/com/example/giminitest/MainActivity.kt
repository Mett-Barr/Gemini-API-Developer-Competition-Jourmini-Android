package com.example.giminitest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.giminitest.BuildConfig.MAPS_API_KEY
import com.example.giminitest.ui.page.GeminiTestPage
import com.example.giminitest.ui.theme.GiminiTestTheme
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.FetchPhotoRequest
import com.google.android.libraries.places.api.net.FetchPlaceRequest


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()


        Places.initializeWithNewPlacesApiEnabled(this, MAPS_API_KEY)
        val placesClient = Places.createClient(this)
//        val center = LatLng(37.7749, -122.4194)
//        val circle = CircularBounds.newInstance(center,  /* radius = */50000.0)
//        val autocompletePlacesRequest =
//            FindAutocompletePredictionsRequest.builder()
//                .setQuery("park")
//                .setRegionCode("ES")
////                .setLocationRestriction(circle)
//                .build()
//        placesClient.findAutocompletePredictions(autocompletePlacesRequest)
//            .addOnSuccessListener { response ->
//                Log.d("!!!", "addOnSuccessListener")
//                val predictions: List<AutocompletePrediction> =
//                    response.autocompletePredictions
//                Log.d("!!!", "addOnSuccessListener predictions size = ${predictions.size}")
//                predictions.forEach {
//                    Log.d("!!!", "addOnSuccessListener: $it")
//                }
//            }
//            .addOnFailureListener {
//                Log.d("!!!", "addOnFailureListener: $it")
//            }


        setContent {
            GiminiTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
//                    BakingScreen()
                    Scaffold {
                        it
                        GeminiTestPage(Modifier.padding(it))


//                        MapTest()
//                        Search()
//
//                        val sheetState = rememberModalBottomSheetState()
//                        var boo by remember { mutableStateOf(true) }
//                        val scope = rememberCoroutineScope()
//                        val b = {
//                            scope.launch {
//                                delay(3.seconds)
//                                boo = true
//                            }
//                        }
//                        AnimatedVisibility(
//                            visible = boo,
//                            enter = fadeIn(),
//                            exit = fadeOut(),
//                        ) {
//                            DialogMap {
//                                boo = false
//                                b()
//                            }
//                        }

                    }
                }
            }
        }
    }
}