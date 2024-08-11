package com.example.giminitest

import android.os.Bundle
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
import com.example.giminitest.data.json.situation.s0.S0
import com.example.giminitest.data.json.situation.s1.S1
import com.example.giminitest.data.json.situation.s1.tmp.S1en
import com.example.giminitest.data.json.situation.s2.tmp.S2
import com.example.giminitest.data.json.situation.s3.tmp.S3Test
import com.example.giminitest.ui.theme.GiminiTestTheme
import com.google.android.libraries.places.api.Places


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        // done
//        S0.test()
//        S1en.test2()

//        S2.test()
//        S3Test.test()

//        openGoogleMapsRoute(this)

//        runBlocking {
//            withContext(Dispatchers.IO) {
//                fetchHybridApiData()
//            }
//        }

//        S3_4test()

        setContent {
            GiminiTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Scaffold {
                        Navigation(Modifier.padding(it))
                    }
                }
            }
        }
    }

    fun placeApiTest() {
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
    }
}