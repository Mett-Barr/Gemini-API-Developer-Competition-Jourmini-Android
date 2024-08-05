package com.example.giminitest.map

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState
import org.json.JSONObject

object RoutesUtil {
    fun decodePolyline(encoded: String): List<LatLng> {
        val poly = ArrayList<LatLng>()
        var index = 0
        val len = encoded.length
        var lat = 0
        var lng = 0

        while (index < len) {
            var b: Int
            var shift = 0
            var result = 0
            do {
                b = encoded[index++].code - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlat = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lat += dlat

            shift = 0
            result = 0
            do {
                b = encoded[index++].code - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlng = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lng += dlng

            val p = LatLng((lat / 1E5), (lng / 1E5))
            poly.add(p)
        }

        return poly
    }

    fun getRoutePolyline(jsonResponse: String): List<LatLng> {
        val jsonObject = JSONObject(jsonResponse)
        val points = jsonObject
            .getJSONArray("routes")
            .getJSONObject(0)
            .getJSONArray("legs")
            .getJSONObject(0)
            .getJSONArray("steps")
            .getJSONObject(0)
            .getJSONObject("polyline")
            .getString("points")

        return decodePolyline(points)
    }
}


val jsonResponse = """
            {
              "routes": [
                {
                  "legs": [
                    {
                      "steps": [
                        {
                          "polyline": {
                            "points": "abcdEfghIjklMnopQrstuVwxyZ"
                          }
                        }
                      ]
                    }
                  ]
                }
              ]
            }
        """


@Preview
@Composable
fun MapsScreen() {
    val jsonResponse = """{
  "routes": [
    {
      "legs": [
        {
          "steps": [
            {
              "polyline": {
                "points": "a~l~Fjk~uOwHJy@P"
              }
            },
            {
              "polyline": {
                "points": "udnnFz~l~OkFk@"
              }
            }
          ]
        }
      ]
    }
  ]
}

    """

    val polylinePoints = remember { RoutesUtil.getRoutePolyline(jsonResponse) }
    val initialPosition = if (polylinePoints.isNotEmpty()) polylinePoints[0] else LatLng(0.0, 0.0)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(initialPosition, 15f)
    }

    Box(
        modifier = Modifier
            .background(color = Color.Gray)
            .fillMaxSize()
            .aspectRatio(0.7f)
            .padding(28.dp)
            .clip(RoundedCornerShape(28.dp))
            .clickable(enabled = false) {  }
            .background(Color.White)
            .padding(24.dp)
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
//            properties = MapProperties(isMyLocationEnabled = false),
//            uiSettings = MapUiSettings(zoomControlsEnabled = true)
        ) {
            Polyline(points = polylinePoints)
        }
    }
}