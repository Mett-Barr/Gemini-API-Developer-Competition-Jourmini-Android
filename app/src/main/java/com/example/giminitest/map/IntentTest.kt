package com.example.giminitest.map

import android.content.Context
import android.content.Intent
import android.net.Uri


fun openGoogleMapsRoute(context: Context) {
    val uri = Uri.parse("https://www.google.com/maps/dir/%E4%B8%AD%E5%B1%B1%E5%85%AC%E5%9C%92/100%E5%8F%B0%E5%8C%97%E5%B8%82%E4%B8%AD%E6%AD%A3%E5%8D%80%E5%8C%97%E5%B9%B3%E6%9D%B1%E8%B7%AF%E4%B8%AD%E5%A4%AE%E8%97%9D%E6%96%87%E5%85%AC%E5%9C%92/%E8%87%BA%E5%8C%97%E5%A4%A7%E5%B7%A8%E8%9B%8B/@25.0477267,121.5357513,13.75z/data=!3m1!5s0x3442abc75d1494bf:0xa58f6b30749edd04!4m20!4m19!1m5!1m1!1s0x3442abc809c883d1:0x2cb7694caf3e6c67!2m2!1d121.5597529!2d25.0386114!1m5!1m1!1s0x3442a97b18d5d865:0xddf0559d94496ed0!2m2!1d121.5268353!2d25.0461209!1m5!1m1!1s0x3442abc75953a09b:0xff4ab59d772a94f8!2m2!1d121.5595066!2d25.0424367!3e2?authuser=1&entry=ttu")
//    val uri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin=Google+Pyrmont+NSW&destination=QVB&destination_place_id=ChIJISz8NjyuEmsRFTQ9Iw7Ear8&travelmode=walking")
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