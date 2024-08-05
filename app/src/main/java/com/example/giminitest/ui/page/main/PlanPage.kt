package com.example.giminitest.ui.page.main

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.giminitest.data.json.ApiJson
import com.example.giminitest.ui.component.DialogMap
import com.example.giminitest.ui.component.YoutubeThumb
import com.example.giminitest.ui.theme.GiminiTestTheme

@Preview(
    widthDp = 730,
    heightDp = 1112,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Preview(
    widthDp = 730,
    heightDp = 1112,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
fun PlanPage(
    navigate: () -> Unit = {},
    modifier: Modifier = Modifier,
    apiJson: ApiJson = ApiJson.fakeJsonObject
) {
    GiminiTestTheme {
        Surface {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = modifier.padding(8.dp)
            ) {
                Row {
                    Icon(Icons.Rounded.ArrowBackIosNew, contentDescription = null, modifier = Modifier.clickable { navigate() })
                    Text("Demo")
                }
                Text("User prompt is here", style = MaterialTheme.typography.headlineLarge)
                Row {
                    Icon(Icons.Rounded.Search, contentDescription = null)
                    Text("Pro Search")
                }
                Row {
                    LazyColumn(
                        Modifier.weight(4f),
                        contentPadding = PaddingValues(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(3) {
                            Card(Modifier.fillMaxWidth()) {
                                Row(Modifier.padding(8.dp)) {
                                    Text("·Search for information...")
                                }
                            }
                        }
                        item {
                            Text(text = "Sources")
                            Spacer(modifier = Modifier.height(8.dp))
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                items(5) {
                                    Card {
                                        Column(Modifier.padding(8.dp)) {
                                            Text("Best\nNightMarket")
                                            Row {
                                                Spacer(
                                                    modifier = Modifier
                                                        .size(24.dp)
                                                        .clip(CircleShape)
                                                        .background(Color(0xffb471bc))
                                                )
                                                Text(text = "Taiwannobsessed · 1")
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        item {
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                items(5) {
                                    Column(Modifier.clip(RoundedCornerShape(16.dp))) {
                                        YoutubeThumb(
                                            videoId = "f4cKo1jFZG0",
                                            Modifier
                                                .width(200.dp)
                                                .aspectRatio(128f / 72f)
                                        )
                                        Text(
                                            text = "Best Night Market", Modifier
                                                .background(Color(0xff007aff))
                                                .width(200.dp)
                                                .padding(8.dp)
                                        )
                                    }
                                }
                            }
                        }
                        item {
                            Text(sampleText)
                        }
                    }
                    Column(Modifier.weight(3f)) {
                        DialogMap(
                            Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                                .padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}

val sampleText = """
    好的，這就為您規劃一個豐富的台北兩天一夜行程，結合了經典景點、特色美食和文青氛圍，讓您深度體驗台北的魅力！

    第一天

    上午：漫步台北城北，感受歷史風情

    景點：大稻埕漫步在大稻埕的迪化街，感受老街的懷舊氛圍。您可以參觀傳統的南北貨店鋪，品嚐在地小吃，或是在紅樓劇場欣賞表演。
    Opens in a new window
    www.travel.taipei
    大稻埕
    景點：保安宮保安宮是台北最古老的廟宇之一，建築精緻，香火鼎盛。您可以參觀廟宇內的文物，感受傳統文化的魅力。
    Opens in a new window
    zh.wikipedia.org
    保安宮
    下午：體驗文青台北，感受藝術氣息

    景點：松山文創園區松山文創園區是一個充滿設計感的文創園區，這裡有許多獨立書店、文創品牌和藝術展覽。您可以逛逛書店、選購文創商品，或是在戶外草地上放鬆身心。
    Opens in a new window
    vacation.eztravel.com.tw
    松山文創園區
    景點：誠品書店敦南店誠品書店敦南店是台北最著名的書店之一，這裡不僅有豐富的書籍，還有文具、咖啡廳和藝文空間。您可以選購喜歡的書籍，或是在咖啡廳裡享受閱讀的樂趣。
    Opens in a new window
    www.bella.tw
    誠品書店敦南店
    晚上：享受台北夜生活，品嚐美食

    美食：饒河街夜市饒河街夜市是台北最熱鬧的夜市之一，這裡有各式各樣的美食小吃，如大腸包小腸、蚵仔煎、滷味等。您可以一邊逛夜市，一邊品嚐美食。
    Opens in a new window
    www.travel.taipei
    饒河街夜市
    景點：台北101欣賞台北101的夜景，感受台北的繁華。
    Opens in a new window
    www.eclathotels.com
    台北101
    第二天

    上午：探索自然美景，感受城市綠洲

    景點：陽明山陽明山是台北近郊的國家公園，這裡有豐富的自然景觀，如花卉、瀑布和溫泉。您可以健行、泡溫泉，或是在花鐘前拍照留念。
    Opens in a new window
    www.housefeel.com.tw
    陽明山
    下午：體驗文創園區，感受藝術氛圍

    景點：華山1914文創園區華山1914文創園區是一個充滿藝術氣息的園區，這裡經常舉辦各種展覽、表演和市集。您可以逛逛市集、欣賞展覽，或是在咖啡廳裡休息。
    Opens in a new window
    www.travel.taipei
    華山1914文創園區
    晚上：享受浪漫夜景，感受台北魅力

    景點：象山從象山山頂可以俯瞰台北市區的夜景，欣賞到台北101的壯麗景觀。
    Opens in a new window
    www.travel.taipei
    象山
    美食：信義區美食 信義區聚集了許多高檔餐廳和特色小店，您可以選擇喜歡的餐廳，享受一頓浪漫的晚餐。
    注意事項：

    交通： 台北的交通非常便利，您可以搭乘捷運、公車或計程車前往各個景點。
    住宿： 台北的住宿選擇很多，您可以根據自己的預算和需求選擇適合的飯店或民宿。
    天氣： 台北的天氣多變，建議出發前查詢天氣預報，並準備合適的衣物。
    美食： 台北的美食多元豐富，您可以品嚐到來自世界各地的美食，也可以品嚐到道地的台灣小吃。
    行程建議：

    上述行程僅供參考，您可以根據自己的興趣和時間調整行程。
    如果您喜歡逛街購物，可以將行程安排得更緊湊一些。
    如果您喜歡悠閒的旅行，可以多安排一些時間在咖啡廳或公園裡休息。
    希望這個行程對您有所幫助，祝您在台北玩得愉快！

    想了解更多台北旅遊資訊，可以參考以下網站：

    台北旅遊網：https://www.travel.taipei/
    好好玩FunIt：https://www.welcometw.com/
    如果您還有其他問題，歡迎隨時提出！

    是否想為這個行程添加更多個人化的元素，例如特定的興趣或美食偏好？
""".trimIndent()