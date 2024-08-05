package com.example.giminitest.map

import android.content.Context
import android.content.Intent
import android.net.Uri


fun openGoogleMapsRoute(context: Context) {
    val uri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin=Google+Pyrmont+NSW&destination=QVB&destination_place_id=ChIJISz8NjyuEmsRFTQ9Iw7Ear8&travelmode=walking")
    val mapIntent = Intent(Intent.ACTION_VIEW, uri)
    mapIntent.setPackage("com.google.android.apps.maps")
    if (mapIntent.resolveActivity(context.packageManager) != null) {
        context.startActivity(mapIntent)
    } else {
        // Handle the case where Google Maps app is not installed
        // You can show a message to the user or open the URL in a web browser
        val webIntent = Intent(Intent.ACTION_VIEW, uri)
        context.startActivity(webIntent)
    }
}