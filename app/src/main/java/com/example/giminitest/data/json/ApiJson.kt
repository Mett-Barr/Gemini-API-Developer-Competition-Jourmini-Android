package com.example.giminitest.data.json


import android.util.Log
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class ApiJson(val items: List<ApiJsonItem>) {
    companion object {
        const val fakeJsonString = """
            {
                "items": [
                    {
                        "_comment": "In Chatbot console"
                    },
                    {
                        "user_input": "黃仁勳上個月來台，都造訪了哪些美食？"
                    },
                    {
                        "llm_output": "1. LLM use Searching tool. 2. LLM generate based on the search results to provide an answer."
                    },
                    {
                        "system_output": {
                            "Youtube_api_output": [
                                {
                                    "video_id": "ep_LWTwK3G8",
                                    "video_title": "台灣夜市美食",
                                    "summary": "介紹台灣夜市的影片",
                                    "locations": ["台北", "台灣"]
                                }
                            ],
                            "Recommendation": [
                                {
                                    "place_id": "id_1",
                                    "name": "南機場夜市"
                                },
                                {
                                    "place_id": "id_2",
                                    "name": "饒河夜市"
                                }
                            ],
                            "system_message": "完成規劃按鈕"
                        }
                    },
                    {
                        "user_interaction": "click the cards for Recommendation."
                    },
                    {
                        "user_system_input": {
                            "interested_locations": [
                                {
                                    "place_id": "id_2",
                                    "name": "饒河夜市"
                                }
                            ]
                        }
                    },
                    {
                        "llm_output": "黃仁勳夜市行程 + 饒河夜市推薦美食....."
                    },
                    {
                        "system_output": {
                            "Youtube_api_output": [
                                {
                                    "video_id": "ep_LWTwK3G8",
                                    "video_title": "台灣夜市美食",
                                    "summary": "介紹台灣夜市的影片",
                                    "locations": ["台北", "台灣"]
                                }
                            ],
                            "Recommendation": [
                                {
                                    "place_id": "id_3",
                                    "name": "士林夜市"
                                },
                                {
                                    "place_id": "id_4",
                                    "name": "臨江夜市"
                                }
                            ],
                            "system_message": "完成規劃按鈕"
                        }
                    },
                    {
                        "user_interaction": "click the button for 完成規劃按鈕."
                    },
                    {
                        "_comment": "Move to Plan Page"
                    },
                    {
                        "plan_data": {
                            "final_plan": "最終規劃",
                            "交通資訊": "Google Map API"
                        }
                    }
                ]
            }
        """

        val fakeJsonObject: ApiJson by lazy {
            Json.decodeFromString(fakeJsonString)
        }

        init {
            Log.d("!!!", fakeJsonObject.toString())
        }
    }
}