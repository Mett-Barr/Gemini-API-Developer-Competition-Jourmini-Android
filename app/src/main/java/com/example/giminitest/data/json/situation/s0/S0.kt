package com.example.giminitest.data.json.situation.s0


import android.util.Log
import com.example.giminitest.data.json.situation.s3.tmp.s
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class S0(
    @SerialName("photo_url")
    val photoUrl: String? = null,
    @SerialName("place_address")
    val placeAddress: String? = null,
    @SerialName("place_coordinates")
    val placeCoordinates: PlaceCoordinates? = null,
    @SerialName("place_id")
    val placeId: String? = null,
    @SerialName("place_name")
    val placeName: String? = null
) {
    companion object {
        fun test() {
            val v = Json.decodeFromString<List<S0?>>(ss)
            Log.d("!!!", v.toString())
        }

        fun getFakeList(): List<S0> {
            val v = Json.decodeFromString<List<S0?>>(ss)
            return v.filterNotNull()
        }
    }
}

private val ss = """[
    {
        "place_id": "ChIJH56c2rarQjQRphD9gvC8BhI",
        "place_name": "Taipei 101",
        "place_address": "Taipei 101, No. 7, Section 5, Xinyi Rd, Xinyi District, Taipei City, Taiwan 110",
        "place_coordinates": {
            "latitude": 25.033976,
            "longitude": 121.56453889999999
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqFvI-i933DsIrsDkya5u84vDJ7pINYMc8EWqh14-ljvhyvisVwfVwA7968WvGh3ZMo6d3KlYPSN388BMihG_nNzJZusTDBrg0s=s4800-w1200-h1600"
    },
    {
        "place_id": "ChIJfUpAzTqsQjQRwQl6ORhwbV0",
        "place_name": "National Palace Museum",
        "place_address": "No. 221, Sec 2, Zhi Shan Rd, Shilin District, Taipei City, Taiwan 111",
        "place_coordinates": {
            "latitude": 25.1023554,
            "longitude": 121.54849250000001
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqFK-zCHOSPSmu7CYKUyLg7pcK-YSYuwvPpMWmKXUBnX_MFU3sg3ln8GKzuA6T5K5LxGyDDEmmQEOvani5cFKw8gI4gXMkrgrog=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJBa_9xLGuQjQRKfnnhr5twuc",
        "place_name": "Shilin Night Market",
        "place_address": "No. 101, Jihe Rd, Shilin District, Taipei City, Taiwan 111",
        "place_coordinates": {
            "latitude": 25.087986899999997,
            "longitude": 121.5242024
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqFNtIcGAcQ10qRMlKwIFuOrf_avPAnD_zgLaPXrJWo6ckbIhq7xwJ1-9B6PovnvcQqrsKVNXU4SoJYH8WI-jPhka2jt5PtJXoE=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJS8fPJPitQjQRebDDT6PjC1w",
        "place_name": "Yangmingshan National Park",
        "place_address": "Taiwan",
        "place_coordinates": {
            "latitude": 25.1942462,
            "longitude": 121.5609363
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqGxZqeYyqU4EUyHzuxePR8rS0N0TevKGlfi-y4T0BVSz0XcRZqCuRR3BU9978k3VpH3y4APTRkBEnbW1IBES3HkR43QiBTaFIg=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJcZT7-hdFXTQR0qekplqCFV8",
        "place_name": "Jiufen Old Street",
        "place_address": "Jishan St, Ruifang District, New Taipei City, Taiwan 224",
        "place_coordinates": {
            "latitude": 25.1098695,
            "longitude": 121.8451827
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqGK4vEGB_KcVSRlwuz53RfrQv26d7VQa1c6goq7HwbgS250NrP-FzzgvsSygNMcg2gRVhzf6a-0wOn2Iucw8kNfSr3iPYq145w=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJkxV677RWXTQRpP6-bLPJ_2M",
        "place_name": "\u5e73\u6eaa\u8001\u8857\uff5c\u5e73\u6eaa\u5929\u71c8\u9054\u4eba Ping-Shi Sky Lantern Professional",
        "place_address": "No. 28\u865f, Pingxi St, Pingxi District, New Taipei City, Taiwan 226",
        "place_coordinates": {
            "latitude": 25.025611899999998,
            "longitude": 121.7388234
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqE91iJIpLLXQFXxZq-sX1UFukgwOc9ZZhM9Ty_jU-6F2qFUrTjG3jOLZYDlCT_bW9TuPYO9CYPpg5q3Y3goYdSGay3Q8KYvh9k=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJkf3MYFilQjQRxSE-z1AbDKQ",
        "place_name": "Tamsui Old Street",
        "place_address": "No. 1, Zhongzheng Rd, Tamsui District, New Taipei City, Taiwan 251",
        "place_coordinates": {
            "latitude": 25.168927,
            "longitude": 121.44409209999999
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqGXH35xrxlbaUBU7i0YJFwvCBrfh_R9kmOKe0QYrl3BqvCcAsDjiBe3Z0t5ySiAqsf5eCxiqbEh2wOYcbTO6S8Pyc9wSNpqA-k=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJPQxXQi6lQjQR32sWffQl12o",
        "place_name": "Tamsui Fisherman's Wharf",
        "place_address": "Tamsui Fisherman's Wharf, Taiwan",
        "place_coordinates": {
            "latitude": 25.1834999,
            "longitude": 121.4097309
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqFPgaSLRvwHv8czFF1MjOnAoL4ZssFmYgs0rY-wULra2pQ5FxQpL8QA4xSC2Thhr-6EE5xwE4yIlrz4Vai0IWVT9bPC384hdrE=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJtzazRopLXTQR6oPhdctkJvU",
        "place_name": "Yeliou",
        "place_address": "Yeliou, New Taipei City, Taiwan",
        "place_coordinates": {
            "latitude": 25.204756999999997,
            "longitude": 121.6896172
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqGvftp-741bZRI-z8TRZrOi5lCW3YlorId3NFUcF8pImZYh8_1z2E17oq906VuJbPS2SshiIgdnUIyTHDiJZtdsyJ4bDdYmqvo=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJX05ITdYdTlMRQ4Eezy1ErZw",
        "place_name": "Elephant Back Trailhead",
        "place_address": "US-20, Yellowstone National Park, WY 82190, USA",
        "place_coordinates": {
            "latitude": 44.5563274,
            "longitude": -110.4039045
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqHbbf7_EyrSs9e6rbXgF2XM6dDVcLim-GHq_nJ_PCiyBlexuF7m1Oso2cO3M2wR57GXWK-_wvYNom2kWyWRYYD9xUDqn7f-5HA=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJ6fE69FCuQjQRPAp8aSmP8a0",
        "place_name": "Beitou Hot Spring Museum",
        "place_address": "No. 2, Zhongshan Rd, Beitou District, Taipei City, Taiwan 112",
        "place_coordinates": {
            "latitude": 25.136569400000003,
            "longitude": 121.50715
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqFFrx57n7X91n8G-TprBeE6gmZAOqwFEHDqByRfZwYgIHpE5lwtIKdHFE_A4t_mKSSRsL4BsWcfXPiWficgr0yWmmoQeuQ7cj0=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJyQOgKx5FXTQRqUqA9kKPVvk",
        "place_name": "Jinguashih(Gold Ecological Park)",
        "place_address": "Ruifang District, New Taipei City, Taiwan 224",
        "place_coordinates": {
            "latitude": 25.108369,
            "longitude": 121.85589499999998
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqFK7AddB9FenrhLHzV72FvIaWdo5y6CBhSjIGFn93JIeETg90eqDS-jm8eHiZaTBNnDenqk0PZV-NBY1Dk6XXUODjJQNr4jJxM=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJTamiuZ2pQjQRsmnfkkID6UM",
        "place_name": "Chiang Kai-shek Memorial Hall",
        "place_address": "Zhongzheng District, Taipei City, Taiwan 100",
        "place_coordinates": {
            "latitude": 25.035501999999997,
            "longitude": 121.5201832
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqE4xc0o0S-It54SkEzsovtGMwCllWHmu0Q2xGFAvu0Hr6uycnXe5gQfoxoAszFbv_y_oTdAL40AoTjZZE-28wtJR_fOAsfR97M=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJO0vOI7-rQjQR3Pl9_4cPK8g",
        "place_name": "Songshan Cultural and Creative Park",
        "place_address": "No. 133\u865f, Guangfu S Rd, Xinyi District, Taipei City, Taiwan 11072",
        "place_coordinates": {
            "latitude": 25.0438366,
            "longitude": 121.5606383
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqGNjAZCio72yToQDfVBSa4RjjjGCzZyiumTRDcnT3dQUBU_cxSwtdNRMKu-StpmXUiE96pZ-MSuf1UGnHaS1abWoy-zam_3Z_A=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJbSTgI2WpQjQRcVwWB2cnyfE",
        "place_name": "Huashan 1914 Creative Park",
        "place_address": "No. 1, Section 1, Bade Rd, Zhongzheng District, Taipei City, Taiwan 100",
        "place_coordinates": {
            "latitude": 25.0440698,
            "longitude": 121.5293583
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqEufaaTd2Xx4mIDubL_X2IuvHl7W5jlvqeKz8GCqGuVzzFwMYjpWSYp1v5mV32KPW994HGKnpC7T8aekOLtU9_2fgx-FEDSgTM=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJCd7n16ipQjQRihzEWF4z6Pg",
        "place_name": "Lungshan Temple",
        "place_address": "No. 211, Guangzhou St, Wanhua District, Taipei City, Taiwan 10853",
        "place_coordinates": {
            "latitude": 25.037310599999998,
            "longitude": 121.49986539999999
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqGXwfIurp8wxQ8PceDnAwFqRyDWWOHU_oUnudAvJfdXq0rnSGkAdHwtkXVhvuxzKe802PCwzQMtJ3Lx7WetW_aevaIJgkQmDds=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJqZwyeygCaDQRTV26zE_KM0M",
        "place_name": "Bitan",
        "place_address": "Bitan, Xindian District, New Taipei City, Taiwan 231",
        "place_coordinates": {
            "latitude": 24.9562706,
            "longitude": 121.53479
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqEJ4QcrTVLhWg-rrjDb4SxQUtIfLLHjJw7Dw8HX5-o_c00NBYmkOW7n3Nk8d2OXSsZ5XlF_Yht4o8yK0MgV8D1I-EEbOkMqcU4=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJX9SSyAirQjQR9B9f7PKLqJo",
        "place_name": "Hushan Hiking Trail",
        "place_address": "Xinyi District, Taipei City, Taiwan 110",
        "place_coordinates": {
            "latitude": 25.0320167,
            "longitude": 121.58748809999999
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqEcHt02fN_G5Bnav6R1GGLEjuEmEUu5rqgGqpsvVkSVTVJaGKff-5NBeDlBbtu0_kmIHk8fpnPqHqxlgqL5L8RrJrXCACjFhgk=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJM4pUiIqsQjQRCsQkmG2dHxU",
        "place_name": "Bihu Park",
        "place_address": "No. 175\u865f, Section 2, Neihu Rd, Neihu District, Taipei City, Taiwan 114",
        "place_coordinates": {
            "latitude": 25.083128799999997,
            "longitude": 121.5834051
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqEIL2e64vOCrmzbzUMTmX2D62Q1ygLwk894jUru_OCJFtTK7ZNF8cEYi3vvPQF__ylR5F5t5ujM_IP90nvsK-FifKbBJakVmG4=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJY5adFT5OXTQRHkmS-RPdhB0",
        "place_name": "Keelung MiaoKou Night Market",
        "place_address": "200, Taiwan, Keelung City, Ren\u2019ai District, \u7389\u7530\u91cc\u4ec1\u4e09\u8def",
        "place_coordinates": {
            "latitude": 25.128445000000003,
            "longitude": 121.7431519
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqE1J4IKdS2iZBu53A2PlNvhmdxiFY009luRBqNpI7ZKdNyqkLw8tLxfY3e2b_qgQ23QAeidUhEMWPgOHR25QZCZDvxiKSAam60=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJS71H94CqQjQRJ0scddOTQvk",
        "place_name": "Zoo - Maokong",
        "place_address": "Zoo - Maokong",
        "place_coordinates": {
            "latitude": 24.979684,
            "longitude": 121.5898661
        }
    },
    {
        "place_id": "ChIJBQDuduDVaDQRKKUSU_2mF-w",
        "place_name": "Sun Moon Lake",
        "place_address": "Sun Moon Lake, Yuchi Township, Nantou County, Taiwan 555",
        "place_coordinates": {
            "latitude": 23.857334200000004,
            "longitude": 120.91591310000001
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqHoRQ0K-T7QwRPs_SlW0q1-xNxIUb3Iky--UL2-VCvgSNt3UFdhVMDsDsc8cpC0gcq4cikC_UZoY2iOxtXgCBllq62aVlUltUg=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJd6tSARHCaDQRHFr7LOLpHGo",
        "place_name": "Qingjing Farm",
        "place_address": "5\u865f, No. 186-1, Renhe Rd, Ren\u2019ai Township, Nantou County, Taiwan 546",
        "place_coordinates": {
            "latitude": 24.058510700000003,
            "longitude": 121.1628284
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqFhaevMUutrWcnjf0v1nSPbRQw17S2kMRMcpPHqKIZr97DjqMxn5wLt6nTyGUzjCppyP_3Ypn5BDbHRUoVlYRsW1A7q1z7mtd4=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJr0ux6mnkaDQRBZsh7CH_hWo",
        "place_name": "\u8c37\u95dc\u6eab\u6cc9",
        "place_address": "\u8c37\u95dc\u6eab\u6cc9, Heping District, Taichung City, Taiwan 424",
        "place_coordinates": {
            "latitude": 24.2033333,
            "longitude": 121.0091667
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqFrqDJJJEM5z_s0RWxMJ-tGYUgxYJkvpV_S3t6RZu7ZeH3qSwe1YimCE-uaIoa5Hq9WZ6XCovJmwUWrI8Xc5rM4hMG35VH2cVo=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJ25Ul-Ic-aTQRNnMAjMs2iJo",
        "place_name": "Rainbow Village",
        "place_address": "408, Taiwan, Taichung City, Nantun District, \u6625\u5b89\u8def56\u5df725\u865f",
        "place_coordinates": {
            "latitude": 24.133715199999997,
            "longitude": 120.6098437
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqE49F77KjdnG5fbICaGUOzArPMmHQl7TfYWKleUHy32gCVjEqXitr4J9r-npY8aTcOeWGdlbiKzdiyrwQmULsadBUtBORM1sAI=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJcaKjTOw9aTQR4mAeJzejtdg",
        "place_name": "National Taichung Theater",
        "place_address": "No. 101\u865f, Section 2, Huilai Rd, Xitun District, Taichung City, Taiwan 407025",
        "place_coordinates": {
            "latitude": 24.1626492,
            "longitude": 120.64030280000001
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqFPUN3pT-YiSwZNmazexrzZtoTHVLoOUtxssaRgcSmysHYnQHeYJp-OAUPtGjrbVINKc9xMtNHLuq8t-MmkMZ_byhtSw9SuZsg=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJK4W2WSIWaTQROebP2ugIGg8",
        "place_name": "Fengchia Night Market",
        "place_address": "Wenhua Rd, Xitun District, Taichung City, Taiwan 407",
        "place_coordinates": {
            "latitude": 24.175946099999997,
            "longitude": 120.6455325
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqFLwlkIFBQoSSvXQVvoBrnVFiryeEnFNWcFGTl82lwGaE7vAHxmVofe9-FmO34SytRe0AjbuSYKQnFSvMjoQ_gJBSvO46b8xWg=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJG8k0XaMaaTQRLsko2uoD5Rs",
        "place_name": "Zhongshe flower market taichung",
        "place_address": "No. 333\u865f, Section 5, Sanfeng Rd, Houli District, Taichung City, Taiwan 421",
        "place_coordinates": {
            "latitude": 24.334676599999998,
            "longitude": 120.72999949999998
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqGWQKXc1_IyeFz7aHPjDMyxFT7zTwxX-5FFxkX-wGkSmYEPhcxynPeIesljYsnLO0NUcV_ruzEJO0gy9sansqn3Li8aYny97jU=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJoWTA-vJsAHwRcb54qNu-srk",
        "place_name": "\u02bbAihualama Trail",
        "place_address": "Na Ala Hele: Aihualama Trail, Honolulu, HI 96822, USA",
        "place_coordinates": {
            "latitude": 21.3413975,
            "longitude": -157.7996972
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqGUOHZaPk7dD5EOq8w6O1D3IWWDBZs-eZG6IuMErBL3Jc_xXGm2sJQuLHzdc95E27HzgEXYU-93ABTN0Yu25dPodr03-kqWFIM=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJsQnTq_4baTQR2NZ2MXTIEwc",
        "place_name": "Xinfeng Fruit Farm",
        "place_address": "No. 264\u865f, Section 2, Zhonghe St, Xinshe District, Taichung City, Taiwan 426",
        "place_coordinates": {
            "latitude": 24.227663699999997,
            "longitude": 120.7983848
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqGAy6eQxWAcHKOqOAUAl9QGeMMuVwsNP_ejUZ1VxoVjATz34-2xbsqjj-E-K--bYZPMPICyWPwNRaP8vo3Wfv6mFuIoySBS5Ts=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJyzSRBng9aTQRNk-Xj7pbpvc",
        "place_name": "National Museum of Natural Science",
        "place_address": "No. 1\u865f, Guanqian Rd, North District, Taichung City, Taiwan 404",
        "place_coordinates": {
            "latitude": 24.1572335,
            "longitude": 120.66606060000001
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqEgkQH3rBy4Ab519TBMpJWqM5neOm2kS2DcQy5WBNV-bzxDhWuRXc1p62KFMw1h_y_rxmtatAK5MD9EBl2BS9WdAEvt3mSAy9U=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJ1bZU8hkQaTQRqWPxCYpghHE",
        "place_name": "Lihpao Resort - DISCOVERY WORLD",
        "place_address": "No. 8\u865f, Furong Rd, Houli District, Taichung City, Taiwan 421",
        "place_coordinates": {
            "latitude": 24.3230546,
            "longitude": 120.69552399999998
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqF6u0JFI94TkWMLtfdqlvCDQq5AacDHPfZ9w32V4CD0coPmfU2apykDNEewKwNKn_Ao4WIflgTW7iaoBPuZavpDxTehNBwlQQM=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJ5SQWm2s9aTQRO9CRyPBXThA",
        "place_name": "Taichung Park",
        "place_address": "No. 65\u865f, Section 1, Shuangshi Rd, North District, Taichung City, Taiwan 404",
        "place_coordinates": {
            "latitude": 24.1448185,
            "longitude": 120.68447619999998
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqGUB3IGMnHdwGowe8vv7i1tDuw3xhDlctmv6j-xgAX-H6eikyWDwcSq8grwGCM3F5_T4u-ZD82HhtUDGfxyDyXuqcv12av-nkc=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJvT5yFSYTaTQRdlamuLSItpM",
        "place_name": "Gaomei Wetlands",
        "place_address": "Gaomei Wetlands, Taiwan",
        "place_coordinates": {
            "latitude": 24.3132762,
            "longitude": 120.54518370000001
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqFMNHKE_bsE4ZANikF8Ow5BQi_A762zPU7iV_HEv4C1o6SzqeIXkQhv-JjyauftksT9vbREcxPKTRKBlgVzUnEshK0gIFf-XjQ=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJk0k-56B-3YgRPufxvWOVHAk",
        "place_name": "Formosa Gardens Village",
        "place_address": "7864 W Irlo Bronson Memorial Hwy, Kissimmee, FL 34747, USA",
        "place_coordinates": {
            "latitude": 28.3404661,
            "longitude": -81.6004818
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqHaPPMcWQfHvvGooQTtTkcrVVAZbeBQIJNOB4-eb7hhfwB5MYrlhugnBCnMmnhv9RPsjAmyEMmXCz4XKP4sRbDXlICVTNLHDD4=s4800-w1242-h343"
    },
    {
        "place_id": "ChIJw2g-MZ_xaDQRiTnTz7upGWg",
        "place_name": "Wuling Farm",
        "place_address": "No. 3-1\u865f, Wuling Rd, Heping District, Taichung City, Taiwan 42495",
        "place_coordinates": {
            "latitude": 24.3450052,
            "longitude": 121.3082054
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqH72yoy_1Q33K8YvNzDxyoaq6G0669EKhEznXcgRK0XggLLH_jfyvuB3rSSVfON8n3LuZ9rUHOItdsEok-moHt1Xno-Pzw7zVY=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJ2ffC3wEOaTQR-YuV-iIXELk",
        "place_name": "Dajia Jenn Lann Temple",
        "place_address": "No. 158\u865f, Shuntian Rd, Dajia District, Taichung City, Taiwan 437",
        "place_coordinates": {
            "latitude": 24.3451924,
            "longitude": 120.62359439999999
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqHgDGZPFYDXCL1Um4aBRIWKP9CJFvB5Yp0l_h-BEN28isWXoEzVt7LJ8N9aJsrWW8KOs9Xuq3ztDsPQa7WvxDbIyi3IoCU8O9w=s4800-w1600-h1536"
    },
    {
        "place_id": "ChIJ9WxLzjYdaTQRvYL_kY_zHws",
        "place_name": "Dongshi Forest Garden",
        "place_address": "No. 6-1\u865f, Shilin St, Dongshi District, Taichung City, Taiwan 423",
        "place_coordinates": {
            "latitude": 24.285300799999998,
            "longitude": 120.86771129999998
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqElTbrozhwBYm-45DDLTphKgPLhSQo2hlKEi0W5zDzyJ0gBDT7dCTB-IBPVmIP8WCBwNn5F6l0zetpox0SmaUjSliNurryi214=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJ0ZUbvJMsaTQReWqnH53U7qc",
        "place_name": "Jiji Green Tunnel",
        "place_address": "552, Taiwan, Nantou County, Jiji Township, \u96c6\u96c6\u706b\u8eca\u7ad9",
        "place_coordinates": {
            "latitude": 23.830749599999997,
            "longitude": 120.7583469
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqGvAplNMkqYpgjJ-BAUw7_vnPRLw5yFi3jouE5AhMXqv6XsV1hFkGMbRycsGxDh3AV6CcoTJAdVNhBW6_3uFg_vf1b6cfIhKg8=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJyzuWapM4aTQRlftmw1KoTHo",
        "place_name": "Eight Trigram Mountains Buddha Landscape",
        "place_address": "No. 31\u865f, Wenquan Rd, Changhua City, Changhua County, Taiwan 500",
        "place_coordinates": {
            "latitude": 24.0784879,
            "longitude": 120.5488211
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqEeJkYQjqgyx7W2VGHBlugmNH3dHPdi6s0b12O3aet0aKK58x5jr-3iNdG6LWnrI5DJrcBwZdHew7bDmOM2y-dKeGu26FWo-U0=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJacBApYw9aTQRTUxbOQdRHJ0",
        "place_name": "Shin Kong Mitsukoshi Taichung Zhonggang Store",
        "place_address": "No. 301\u865f, Taiwan Ave, Xitun District, Taichung City, Taiwan 407",
        "place_coordinates": {
            "latitude": 24.164767299999998,
            "longitude": 120.6434748
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqHimUnCtU3llYC5mVFAFYYUqAQRwQ4LPjjgbUstpvUSj2KBsYBe2JgthiQ85EQn77oftCCmzN_qz-V9vKOkWi8Mx5ExhfbHnWg=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJo3zE2vqzcTQRf_VdSaifF_c",
        "place_name": "Kenting National Park",
        "place_address": "Pingtung County, Taiwan",
        "place_coordinates": {
            "latitude": 21.9483307,
            "longitude": 120.77975159999998
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqE1EuUN6rfkNJqxY_UJ0XyJfydrUZvmQZVzrHzSVgCQGvttr10iIll-DeYcB57_POVtR47Y5CDDYSZRliG4pW3r-2fjy5wRlTM=s4800-w736-h488"
    },
    {
        "place_id": "ChIJKxKvSVTnbjQR7LSozO_p2ZE",
        "place_name": "Alishan Township",
        "place_address": "Alishan Township, Chiayi County, Taiwan 605",
        "place_coordinates": {
            "latitude": 23.4354677,
            "longitude": 120.78096759999998
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqHXfVNqJEACEr6qWmNMpq0mtaTyd9_6uwzuJd298_b8ev36Tskv-QWkJMKWIwzyUTt2I5uKrb5EC3zua6GLUGc8JPuWB9HDzjw=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJtT-kzq8DbjQRmdG0FjtzdWk",
        "place_name": "Qijin District",
        "place_address": "Qijin District",
        "place_coordinates": {
            "latitude": 22.6141771,
            "longitude": 120.2659394
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqEC8oKTPmXR13FYzY-LBFCNZnfwGKpxXYesLk8PxR28ia07ngbd0HPblgNizSJ4nJ3jG6IvuYP5qmdfasVPexmILjaSUf-_dTE=s4800-w1600-h1080"
    },
    {
        "place_id": "ChIJAZBaKn8DbjQRqpQI86o3ryg",
        "place_name": "85 Sky Tower",
        "place_address": "No. 5\u865f, Ziqiang 3rd Rd, Lingya District, Kaohsiung City, Taiwan 802",
        "place_coordinates": {
            "latitude": 22.611693799999998,
            "longitude": 120.3001305
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqEKJe_lyL4W2YSUinYUVzwZsTPU9DVNO758z-e9b7oyBb6g0gwM2PttphpPAoAZ1fIJ-4t1bzMbYiqEvU1fzbVlejJ3lZ6m_ac=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJbYl7d2F2bjQRnFdvyMBuZfI",
        "place_name": "Chikan Tower",
        "place_address": "No. 212, Section 2, Minzu Rd, West Central District, Tainan City, Taiwan 700",
        "place_coordinates": {
            "latitude": 22.997477999999997,
            "longitude": 120.2025433
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqG86zHH3zVdP9d-m5eSaiBkWFBaPiiExjFfsQpmOz6NYDEUfinTFqBScDurVJQGokHj2DzguaPzKEMpm4q27zohUHIK-ZCEZHc=s4800-w1024-h682"
    },
    {
        "place_id": "ChIJPbkMK21qbjQR8g3_lDT5L1U",
        "place_name": "Meinong Folk Village",
        "place_address": "No. 80\u865f, Lane 421, Section 2, Zhongshan Rd, Meinong District, Kaohsiung City, Taiwan 843",
        "place_coordinates": {
            "latitude": 22.8931389,
            "longitude": 120.51397700000001
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqHwJeX7_JeZt-p9KwRA95AuZNrW0Gea61EEEtGa1xmAeU5af7YRYmCZa4WjUBiy89bs7iXVtDDpPQF0c8fovPIoKH3X34B9y00=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJr_5yL_rbJIgRHnHDZAnFWwA",
        "place_name": "Lotus Pond",
        "place_address": "28747 Hoover Rd, Warren, MI 48093, USA",
        "place_coordinates": {
            "latitude": 42.505724,
            "longitude": -83.0072236
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqFSezmtcZnaaokC60rCV2CoarXBn_sDxIQVH7p49YayDeoioW4kjuKnK4yau3MrL9sRXg0sOWBmI6teG5r_oOPPFkEv5LFYwkk=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJxznXwIsEbjQR_eygv0Lo5tM",
        "place_name": "Liouhe Tourist Night Market",
        "place_address": "Liuhe 2nd Rd, Sinsing District, Kaohsiung City, Taiwan 800",
        "place_coordinates": {
            "latitude": 22.6320758,
            "longitude": 120.2991547
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqHohCPdfWGzaCEYvCswCD5j9EsyAYXh5GpN2bw20RFJm2YWZDFA8uJad9hIczTcTBQRV5t46fLyS_kqS-3F_yEJ1i_QLhdop4Q=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJh292UXlqK4gRW-jey2S6czE",
        "place_name": "Fo Guang Shan Temple of Toronto",
        "place_address": "6525 Millcreek Dr, Mississauga, ON L5N 7K6, Canada",
        "place_coordinates": {
            "latitude": 43.5911621,
            "longitude": -79.74286649999999
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqEj7mpmvfuXSZXJqo35Ha3ziVGuOrQC5ytRWbm2gAp7I3UYLZp7delbJ4bLX3TN9bSuRxZ3d2w38HgwhwxtVpvk5TyjDdWXwgw=s4800-w700-h300"
    },
    {
        "place_id": "ChIJVakFmYvvcTQRW2lecOLzlcY",
        "place_name": "Lambai Island",
        "place_address": "Lambai Island, Liuqiu Township, Pingtung County, Taiwan 929",
        "place_coordinates": {
            "latitude": 22.3404158,
            "longitude": 120.37151490000001
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqGWFna9Z2HA6EYTQS6yMMd2-j90ZUMd-EQu_xv4PtO9plMy6pw8shlc68N-MuzhM8ENQEXTIkmw-nv1uShbNnTLmNSOOYj_hPQ=s4800-w1478-h1108"
    },
    {
        "place_id": "ChIJFbzVrGJ2bjQRkZC9jslaIgs",
        "place_name": "Tainan Confucius Temple",
        "place_address": "No. 2\u865f, Nanmen Rd, West Central District, Tainan City, Taiwan 700",
        "place_coordinates": {
            "latitude": 22.9905296,
            "longitude": 120.2040401
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqHNmY8hZ5HuVkxQZM6b6WoI_36WYhjB9DYn_nYslbEUksSobsswJzJ8WMZyFPKd001z_ukdfRX_7anpPX0SNciX8oSQxigtrB0=s4800-w1024-h682"
    },
    {
        "place_id": "ChIJq6qqqnp0bjQRpvTHZeYTjKg",
        "place_name": "Chimei Museum",
        "place_address": "No. 66\u865f, Section 2, Wenhua Rd, Rende District, Tainan City, Taiwan 717015",
        "place_coordinates": {
            "latitude": 22.9345608,
            "longitude": 120.2260268
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqFv2rsqcOagHjyRpDTPJt2Q82apb2whsllk2oGvmCNWKhgc8rQdnq8mSoszFlh-x5S3FG9qi93STAHW-0rR36XILrV_0KY5Q-E=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJTRbkzL_WbTQRTrfGfckHIrc",
        "place_name": "Qigu Salt Mountain",
        "place_address": "724, Taiwan, Tainan City, Qigu District, \u9e7d\u57d5\u91cc66\u865f",
        "place_coordinates": {
            "latitude": 23.154256,
            "longitude": 120.1001723
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqFGQlC19YD7K5nvPiWQmWPSZjpv9OGct7hgGxlf3BcnpjP6Znj9RDzG2MIqBgvZwYy7T-xradoPnRD3q1xFcZ39nNuGbobZ99c=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJZ-TjeHN2bjQR8a3Jat0VHps",
        "place_name": "Anping Old Fort",
        "place_address": "No. 82, Guosheng Rd, Anping District, Tainan City, Taiwan 708",
        "place_coordinates": {
            "latitude": 23.001509300000002,
            "longitude": 120.1606244
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqGggAO2os3mmdvN-njYyjiUjP2GTpheyV7LKh8-Q4ufbZc1T35sYpyxh5U4A8IaRbIQ6dEH3dxn8CmDgXk13HoIo4bkfVYckWI=s4800-w1600-h1365"
    },
    {
        "place_id": "ChIJzVyTIfsEbjQRveyTbDNO9AA",
        "place_name": "Love River",
        "place_address": "Love River, Kaohsiung City, Taiwan",
        "place_coordinates": {
            "latitude": 22.6529037,
            "longitude": 120.3054076
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqFuUSqtqjSJz1Me9xL9Iv6vzKqwgWqQ3gQwqjYGG5HoOATP6-C2U_NuNzzJsuxIWfpbKNTnChjGD3vI-rwUs20EdwqipU7zGh0=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJyWfQ7mwEbjQRX1c3vnfhp0A",
        "place_name": "Shoushan Zoo",
        "place_address": "No. 350\u865f, Wanshou Rd, Gushan District, Kaohsiung City, Taiwan 80444",
        "place_coordinates": {
            "latitude": 22.634557299999997,
            "longitude": 120.27517109999998
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqGadvi3FPyihMwUi3LHuKPT4c1u5VMZJKDfzlHkBFCFUETMNOHR5GFbeTxTCkd-ZHsTihkVtO2O_1_h8xt5vnXlLYBzXVuR9OM=s4800-w800-h533"
    },
    {
        "place_id": "ChIJ254iC5xGbjQRyDdlAoB2cW4",
        "place_name": "Maolin Scenic Spot Entrance",
        "place_address": "Maolin District, Kaohsiung City, Taiwan 851",
        "place_coordinates": {
            "latitude": 22.880643,
            "longitude": 120.6501
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqHijw-z3FD9Pqg8ArFNorRuXcPfYk5SnC9-oB5VkRqBRKxUnry55KhqluGgerNCACBArYh6gQGDkrxV4bDX33juHiFDY8E2V9Q=s4800-w1200-h900"
    },
    {
        "place_id": "ChIJSfNljJ2NbjQRKpPO1fEKKsk",
        "place_name": "Guanziling Hot Spring",
        "place_address": "Baihe District, Tainan City, Taiwan 732",
        "place_coordinates": {
            "latitude": 23.3396518,
            "longitude": 120.50438999999999
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqEIIudvL19nTSBZ3I9e_51uxtuq6HB8hQ7F1PXjTTC49aCnpXi5QhsMbN9gZPPjjfoYO2ICkCGtf1WchP9cEhognyYr9zelPK0=s4800-w1600-h1600"
    },
    null,
    {
        "place_id": "ChIJK14oxggEbjQR7C0EK_wuKQM",
        "place_name": "Sizihwan",
        "place_address": "Sizihwan, Gushan District, Kaohsiung City, Taiwan 804",
        "place_coordinates": {
            "latitude": 22.6281882,
            "longitude": 120.2644851
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqF0lTxHASIoQcZZ-lyJ7HHINogxEvFo8HX7jdRmLeYjXNKfOpGNCjxbzsPFn3fcUziJOZqN90OaMdRk_ALBaxP5spzE5ED-7_Y=s4800-w1600-h1536"
    },
    {
        "place_id": "ChIJ7-fCX4SCaDQRMaqw4IX92d0",
        "place_name": "Taroko National Park",
        "place_address": "972, Taiwan, Hualien County, Xiulin Township, \u5bcc\u4e16291\u865f",
        "place_coordinates": {
            "latitude": 24.1939246,
            "longitude": 121.4906668
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqE0_w1jYAbPnS2wl8KoYZLdSMh3dopOOE-nySDKqlawlUbPF-nVhWrFjjE00_Wx2eJTDibesl3GvDf8g0zERgDSYLLiXVpMCk4=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJ9SCI5oedaDQRijf91YB4Ag0",
        "place_name": "Qixingtan Beach",
        "place_address": "Qixingtan Beach, Hualien County, Taiwan",
        "place_coordinates": {
            "latitude": 24.0430498,
            "longitude": 121.62249260000002
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqEERsePIwjy548Dn4vEb9jhRDEb-wIcud9sVm1uzFeD8kILUNz0-1BDEr5IcPhaV2RFqjXJW0s1mlYP3PwYStF-VAFoYhZfBkM=s4800-w1600-h960"
    },
    {
        "place_id": "ChIJp1E-7EhwbzQRuDsz-li3qrI",
        "place_name": "Sanxiantai",
        "place_address": "No. 74\u865f, Jihui Rd, Chenggong Township, Taitung County, Taiwan 961",
        "place_coordinates": {
            "latitude": 23.1261358,
            "longitude": 121.4216802
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqE9NXQoeqKYFpmU1RUJoSHtFlLwCH-3z8p71PzNhiLRGQluKo9rrOxvaxveG7jvxTO83n2vO1nYXI0HG9Xx4BTLH6U8Y8CxINs=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJMexpwXNHeGkR941aT6qG1SU",
        "place_name": "Green Island",
        "place_address": "Green Island, QLD, Australia",
        "place_coordinates": {
            "latitude": -16.7597228,
            "longitude": 145.9738016
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqHJNrgbnWGbUb-korQkRuqYJJjFgdMjk-LWIuKqNOSJFtd8M5AuiS18r1qe-NdjMF_DRgvkCr5y7oXHwOYnbcyIHQhgkYehKE0=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJAXg9jisJcDQRf-OAIgTlLZM",
        "place_name": "Orchid Island",
        "place_address": "Orchid Island, Lanyu Township, Taitung County, Taiwan 952",
        "place_coordinates": {
            "latitude": 22.0435616,
            "longitude": 121.548418
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqHctQ6QlbXSDvcw4cuGaX5YVOwbiankl2PlqfSFt3A0yQRYmmZ8CSkR9DEsHmazaLibshp0qJEkx2ocPqZI0wKHO919gL1xayM=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJZatyKu4JbzQRyHuSojQ6qQ0",
        "place_name": "Brown Boulevard",
        "place_address": "958, Taiwan, Taitung County, Chishang Township, \u9326\u65b0\u4e09\u865f\u9053\u8def",
        "place_coordinates": {
            "latitude": 23.0988065,
            "longitude": 121.2130022
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqEtJLuU4JNHuDVqppIJyzzlu7A6CJaMMA9MI3lxIQZWTu_T1bfAczV_gBBa31NLdMoWeeKAzEn15e9JTwnDsRd2xkp8ackohCU=s4800-w1600-h1600"
    },
    null,
    {
        "place_id": "ChIJR32Q_HJGbzQRRL_0TxjNtQA",
        "place_name": "Ruisui Ranch",
        "place_address": "978, Taiwan, Hualien County, Ruisui Township, 6\u9130157\u865f",
        "place_coordinates": {
            "latitude": 23.479209299999997,
            "longitude": 121.34595650000001
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqF1ol5sRvJC_miX9NLyH_lLpkyxrj3eQdv1TjrMCxWzHJR-svIVy3aPT3A3q4-egk75nWoeEOJEM50DqUcpbXGA9EAHd0CDckg=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJ3eVHa7SjaDQR1K-MKuWZ5S4",
        "place_name": "Liyu Lake",
        "place_address": "Liyu Lake, Shoufeng Township, Hualien County, Taiwan 974",
        "place_coordinates": {
            "latitude": 23.9278268,
            "longitude": 121.50987870000002
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqE4Mq5qRto7pK9673uYiDvTKgoJPYM6gMb__OPeynvudO7Zprmxa7MFxisA426TJPCMvbQRdC6vvDc_ty4jSM5tDkA05LbR6v4=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJAQAAADSkbzQR2E5XyomxUJo",
        "place_name": "Luye Highlands",
        "place_address": "No. 46\u865f, Gaotai Rd, Luye Township, Taitung County, Taiwan 955",
        "place_coordinates": {
            "latitude": 22.916449,
            "longitude": 121.12159489999999
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqFxV5M5N__KM2GuOT4X6CbbAJdRKAswoNZkI41me-h6WhC2pdjOEHC9ZOmn7OZQtELB9JfghhL2FXyQS0vuDheE6mWwjK6bljY=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJ3eVHa7SjaDQR1K-MKuWZ5S4",
        "place_name": "Liyu Lake",
        "place_address": "Liyu Lake, Shoufeng Township, Hualien County, Taiwan 974",
        "place_coordinates": {
            "latitude": 23.9278268,
            "longitude": 121.50987870000002
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqE4Mq5qRto7pK9673uYiDvTKgoJPYM6gMb__OPeynvudO7Zprmxa7MFxisA426TJPCMvbQRdC6vvDc_ty4jSM5tDkA05LbR6v4=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJ7yDuP97JbzQRr_mzjOYs7tc",
        "place_name": "Zhiben Hot Spring",
        "place_address": "Beinan Township, Taitung County, Taiwan 954",
        "place_coordinates": {
            "latitude": 22.6930439,
            "longitude": 121.01812399999999
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqEingvkGffheVG6BNwKnlOyEh80fXTDbxe-IOHROqEBVqBZGpUIf8lpfpJxjmq8hiSTWv-CVw6ZsJVg29Fu2b7udMQEV1JSQ7E=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJ82el9vKgaDQRoDGNDCMauMY",
        "place_name": "East Coast National Scenic Area",
        "place_address": "No. 25, Xincun Rd, Chenggong Township, Taitung County, Taiwan 96144",
        "place_coordinates": {
            "latitude": 23.0201614,
            "longitude": 121.3245523
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqHcqgSpfHQogufwUZyBKQsrfYp1HLb9IcYgk_wFbVGAO0AHwrguvlFNVW_lfI_W81zXC_aIgL8Qo4EzDu0scQ7w43Pj73T4K6Y=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJRYD-WJFQbzQRTwg4oh_QjHU",
        "place_name": "Shitiping",
        "place_address": "977, Taiwan, Hualien County, Fengbin Township, \u53f011\u7dda",
        "place_coordinates": {
            "latitude": 23.4886832,
            "longitude": 121.51379170000001
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqGo-9R4KdMY4XzCz_Eye0gqyAgSj4bgaD2ZNcjkPnEuCkA0rut2qs6838xcWgGN6C_ePuJu8PkbYAD4rAwAGPyNfmFsN7HEqq0=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJ-Qdkbe2gaDQRCtLcEau0bi8",
        "place_name": "Farglory Ocean Park",
        "place_address": "974, Taiwan, Hualien County, Shoufeng Township, \u798f\u5fb7189\u865f",
        "place_coordinates": {
            "latitude": 23.9012596,
            "longitude": 121.6035363
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqFFaOGPcDOW3n5ruDP6peU5Mi6UZF98tp7MgiI9fmQgmUsFrDjNw6lNZHT0VnDYudo9tfPjEjFND6ifURE11pZvY6YIzCyUg0M=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJY9B77bifaDQR_9-5R68pDfQ",
        "place_name": "Hualien Gangtian Temple",
        "place_address": "No. 15\u865f, Lane 500, Section 1, Zhongshan Rd, Hualien City, Hualien County, Taiwan 970",
        "place_coordinates": {
            "latitude": 24.007524099999998,
            "longitude": 121.58745850000001
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqFoFfTM6m4l5wisvRWgu0OaaUOJc0Vm3TM_mwcdHUFd7wXhjqKnB-vHNGJ1rXYbmSu3MqFjcrCsxVwn0lFh_EtPAsW3405jHVo=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJe6sIArKfbzQRr3v8H8Sk55o",
        "place_name": "Donghe Bun Shop",
        "place_address": "959, Taiwan, Taitung County, Donghe Township, \u5357\u6771\u6cb315\u9130420\u865f",
        "place_coordinates": {
            "latitude": 22.9685103,
            "longitude": 121.3043279
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqH8swxjuxWcCFEVCA5WElS5m803l-jORQcVf2hDOpsBr8IjKSIDCKDrOypJxRB6lhsVCfSXtxnZt1vNm2xcfuR_30grRpojodk=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJ71R7iBfMbzQRZEk55eHhgts",
        "place_name": "Kinchen Mountain",
        "place_address": "Kinchen Mountain, Jinfeng Township, Taitung County, Taiwan 964",
        "place_coordinates": {
            "latitude": 22.625939,
            "longitude": 120.97600399999997
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqGlYEsDwRkvjwLjjZQkeyZbMm7Zu8RRs5ioiORhVAnkzdw6h7npVJricHhUhPSOOoiPpVwlt73cNIH52KYvCtrD8m3TKdz-nXY=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJx9oJH165bzQRHtM1Bkgvyyo",
        "place_name": "Taitung Forest Park",
        "place_address": "No. 300\u865f, Huatai Rd, Taitung City, Taitung County, Taiwan 950",
        "place_coordinates": {
            "latitude": 22.768175799999998,
            "longitude": 121.15625899999999
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqHbnwzRBN08KGY0Azy5ZuAkAdp8h_LZXYCGiB6qXQ3x1BIY2xVK2KssxHpszmjwNv8TRt6QJ1URJG-JpfzwvJBhYYZlkYTmuXk=s4800-w1600-h1600"
    },
    {
        "place_id": "ChIJZbi9QWqiaDQR994E82gxZfM",
        "place_name": "\u6728\u74dc\u6eaa",
        "place_address": "Taiwan, \u82b1\u84ee\u7e23\u6728\u74dc\u6eaa",
        "place_coordinates": {
            "latitude": 23.978983,
            "longitude": 121.4742719
        },
        "photo_url": "https://lh3.googleusercontent.com/places/ANXAkqHXT9otKdUpwANGJtnrlnu_x_r9kMJMD2l5Tmupgn8-WmtmJ7fE_6jObqJF5AOjxsQ-n_TEG3CFeQtabVfpB-Y5w5xpWemBWtg=s4800-w1600-h1600"
    }
]"""