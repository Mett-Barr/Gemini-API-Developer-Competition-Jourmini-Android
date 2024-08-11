package com.example.giminitest.data.json.situation.s3.s3_2

import android.util.Log
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class S3_2(
    val provide_options: ProvideOptions
)

@Serializable
data class ProvideOptions(
    val path: String,
    val plan_options: String,
    val lnode: String,
    val messages: List<Message>
)

@Serializable
sealed class Message {
    @Serializable
    @SerialName("SystemMessage")
    data class SystemMessage(val content: String) : Message()

    @Serializable
    @SerialName("HumanMessage")
    data class HumanMessage(val content: String) : Message()

    @Serializable
    @SerialName("AIMessage")
    data class AIMessage(
        val content: String,
        val response_metadata: ResponseMetadata,
        val id: String,
        val usage_metadata: UsageMetadata
    ) : Message()
}

@Serializable
data class ResponseMetadata(
    val prompt_feedback: PromptFeedback,
    val finish_reason: String,
    val safety_ratings: List<SafetyRating>
)

@Serializable
data class PromptFeedback(
    val block_reason: Int,
    val safety_ratings: List<String>
)

@Serializable
data class SafetyRating(
    val category: String,
    val probability: String,
    val blocked: Boolean
)

@Serializable
data class UsageMetadata(
    val input_tokens: Int,
    val output_tokens: Int,
    val total_tokens: Int
)

private val fakeJsonString = """
    {"provide_options": {"path": "provide_options", "plan_options": "鹽水蜂炮活動附近，有很多好吃的小吃和值得一遊的景點！以下列舉一些推薦：\n\n**小吃：**\n\n* **鹽水意麵：** 鹽水最有名的小吃之一，以獨特的口感和清爽的湯頭聞名。推薦老店「阿國意麵」和「阿三意麵」。\n* **鹽水碗粿：** 鹽水碗粿以米漿製作，口感綿密，搭配醬油膏和香菜，風味獨特。推薦「阿婆碗粿」和「正宗鹽水碗粿」。\n* **鹽水蝦捲：** 鹽水蝦捲以新鮮的蝦肉和豬肉製成，外皮酥脆，內餡鮮美。推薦「阿輝蝦捲」和「金龍蝦捲」。\n* **鹽水豬血糕：** 鹽水豬血糕以糯米製成，口感Q彈，搭配醬油膏和花生粉，風味獨特。推薦「阿伯豬血糕」和「阿嬤豬血糕」。\n* **鹽水豆花：** 鹽水豆花以黃豆製成，口感滑嫩，搭配糖水和配料，清爽可口。推薦「阿婆豆花」和「阿公豆花」。\n\n**景點：**\n\n* **鹽水八角樓：** 鹽水八角樓是清代建築，具有獨特的八角形建築風格，是鹽水重要的歷史建築。\n* **鹽水武廟：** 鹽水武廟是台灣重要的廟宇之一，供奉關聖帝君，建築精美，香火鼎盛。\n* **鹽水天主教堂：** 鹽水天主教堂是台灣最早的天主教堂之一，建築風格獨特，是鹽水重要的歷史建築。\n* **鹽水觀音寺：** 鹽水觀音寺是台灣重要的佛教寺廟之一，供奉觀世音菩薩，建築精美，香火鼎盛。\n* **鹽水老街：** 鹽水老街是鹽水最熱鬧的街道之一，沿街有許多傳統商店和美食攤位，是感受鹽水文化的好去處。\n\n**其他建議：**\n\n* 鹽水蜂炮活動期間，人潮眾多，建議事先規劃好行程，並注意自身安全。\n* 鹽水蜂炮活動期間，許多商店和餐廳會提早打烊，建議事先確認營業時間。\n* 鹽水蜂炮活動期間，交通可能會比較擁擠，建議提前做好交通規劃。\n\n希望以上資訊對您有所幫助！祝您在鹽水蜂炮活動期間玩得開心！\n", "lnode": "provide_options", "messages": [SystemMessage(content="Based on the user"s input, suggest potential travel destinations they might be interested in. If the user has mentioned specific locations, consider those in your suggestions. User"s mentioned locations: none mentioned"), HumanMessage(content="在鹽水蜂炮的活動附近，有甚麼推薦小吃及景點?"), AIMessage(content="鹽水蜂炮活動附近，有很多好吃的小吃和值得一遊的景點！以下列舉一些推薦：\n\n**小吃：**\n\n* **鹽水意麵：** 鹽水最有名的小吃之一，以獨特的口感和清爽的湯頭聞名。推薦老店「阿國意麵」和「阿三意麵」。\n* **鹽水碗粿：** 鹽水碗粿以米漿製作，口感綿密，搭配醬油膏和香菜，風味獨特。推薦「阿婆碗粿」和「正宗鹽水碗粿」。\n* **鹽水蝦捲：** 鹽水蝦捲以新鮮的蝦肉和豬肉製成，外皮酥脆，內餡鮮美。推薦「阿輝蝦捲」和「金龍蝦捲」。\n* **鹽水豬血糕：** 鹽水豬血糕以糯米製成，口感Q彈，搭配醬油膏和花生粉，風味獨特。推薦「阿伯豬血糕」和「阿嬤豬血糕」。\n* **鹽水豆花：** 鹽水豆花以黃豆製成，口感滑嫩，搭配糖水和配料，清爽可口。推薦「阿婆豆花」和「阿公豆花」。\n\n**景點：**\n\n* **鹽水八角樓：** 鹽水八角樓是清代建築，具有獨特的八角形建築風格，是鹽水重要的歷史建築。\n* **鹽水武廟：** 鹽水武廟是台灣重要的廟宇之一，供奉關聖帝君，建築精美，香火鼎盛。\n* **鹽水天主教堂：** 鹽水天主教堂是台灣最早的天主教堂之一，建築風格獨特，是鹽水重要的歷史建築。\n* **鹽水觀音寺：** 鹽水觀音寺是台灣重要的佛教寺廟之一，供奉觀世音菩薩，建築精美，香火鼎盛。\n* **鹽水老街：** 鹽水老街是鹽水最熱鬧的街道之一，沿街有許多傳統商店和美食攤位，是感受鹽水文化的好去處。\n\n**其他建議：**\n\n* 鹽水蜂炮活動期間，人潮眾多，建議事先規劃好行程，並注意自身安全。\n* 鹽水蜂炮活動期間，許多商店和餐廳會提早打烊，建議事先確認營業時間。\n* 鹽水蜂炮活動期間，交通可能會比較擁擠，建議提前做好交通規劃。\n\n希望以上資訊對您有所幫助！祝您在鹽水蜂炮活動期間玩得開心！\n", response_metadata={"prompt_feedback": {"block_reason": 0, "safety_ratings": []}, "finish_reason": "STOP", "safety_ratings": [{"category": "HARM_CATEGORY_SEXUALLY_EXPLICIT", "probability": "NEGLIGIBLE", "blocked": False}, {"category": "HARM_CATEGORY_HATE_SPEECH", "probability": "NEGLIGIBLE", "blocked": False}, {"category": "HARM_CATEGORY_HARASSMENT", "probability": "NEGLIGIBLE", "blocked": False}, {"category": "HARM_CATEGORY_DANGEROUS_CONTENT", "probability": "NEGLIGIBLE", "blocked": False}]}, id="run-bcfc7b09-9fa5-4d8c-8bf8-8ed2096d0039-0", usage_metadata={"input_tokens": 58, "output_tokens": 578, "total_tokens": 636})]}}
""".trimIndent().replace("'", "\"")

private val fakeJsonObject: S3_2 by lazy {
    Json.decodeFromString(fakeJsonString)
}


fun S3_2test() {
    Log.d("!!!", "S3_2test: $fakeJsonObject")
}