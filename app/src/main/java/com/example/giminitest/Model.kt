package com.example.giminitest

import com.google.ai.client.generativeai.GenerativeModel

enum class Model(val str: String) {
    GEMINI_1_5_PRO("gemini-1.5-pro-latest"),
    GEMINI_1_5_FLASH("gemini-1.5-flash-latest"),
    GEMINI_1_0_PRO("gemini-pro"),
    GEMINI_1_0_PRO_VISION("gemini-pro-vision"),
    TEXT_EMBEDDING("text-embedding-004"),
    AQA("aqa");

    val model by lazy { GenerativeModel(str, BuildConfig.apiKey) }
}