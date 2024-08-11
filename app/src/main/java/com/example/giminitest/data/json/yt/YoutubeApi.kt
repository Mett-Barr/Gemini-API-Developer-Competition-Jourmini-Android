package com.example.giminitest.data.json.yt


import com.example.giminitest.data.json.ApiJson
import com.example.giminitest.data.json.ApiJson.Companion
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class YoutubeApi(
    @SerialName("results")
    val results: List<Result>
) {
    companion object {
        val fakeJsonString =
            """
                {
                  "results": [
                    {
                      "results": [
                        {
                          "video_title": "【台湾グルメ⑥⓪⑧】新企画！真夏の台湾旅行の醍醐味！大人気の寧夏夜市で最高の晩酌セットを作ろう！",
                          "video_id": "3UKxSIHO1qw"
                        },
                        {
                          "video_title": "✌️來一趟夜市之旅,沉浸在攤販的美味香氣中😋",
                          "video_id": "X6u3p3qonYc"
                        },
                        {
                          "video_title": "【桃園中壢】必吃 ！２大夜市６家推薦美食！中壢夜市～鵪鶉蛋加鮮蝦創意滿分、口味多元麥仔煎、獨門醬料現燙魷魚；中原夜市～國民小吃金沙臭豆腐、超Q地瓜球、古早味台式刀削冰｜1000步的繽紛台灣 Ep431",
                          "video_id": "c4s3iWgZXZM"
                        }
                      ]
                    },
                    {
                      "results": [
                        {
                          "video_title": "✌️來一趟夜市之旅,沉浸在攤販的美味香氣中😋",
                          "video_id": "X6u3p3qonYc"
                        },
                        {
                          "video_title": "吃爆高雄！14間高雄銅板美食吃不停！15元粉圓冰、超牽絲雞排、越臭越愛的⋯⋯｜KKday",
                          "video_id": "QCUXy0gUC54"
                        },
                        {
                          "video_title": "【高雄苓雅】不踩雷熱門美食看這集！自強夜市在地人也愛逛～道地天津煎餅果子原味重現，50年古早味點心白糖粿、千層酥脆創意肉夾饃，還有經典北方麵食館，一起前進高雄吃美食！｜1000步的繽紛台灣 Ep407",
                          "video_id": "FkG5xknIQYc"
                        }
                      ]
                    },
                    {
                      "results": [
                        {
                          "video_title": "台灣最新米其林餐廳揭幕! 你絕對不能錯過的頂級美食!",
                          "video_id": "wdMSZ5RmSds"
                        },
                        {
                          "video_title": "民宿老闆推薦美食，炸彈蔥油餅一樣好好吃❤️",
                          "video_id": "FC6IjLUlhKw"
                        },
                        {
                          "video_title": "吃爆鳳林！在地人早上都吃這？辣死四川麵，檸檬汁配臭豆腐？冰花大煎餃🥟",
                          "video_id": "Q1XcfrOziUk"
                        }
                      ]
                    }
                  ]
                }
            """.trimIndent()

        val fakeJsonObject: YoutubeApi by lazy {
            Json.decodeFromString(fakeJsonString)
        }
    }
}