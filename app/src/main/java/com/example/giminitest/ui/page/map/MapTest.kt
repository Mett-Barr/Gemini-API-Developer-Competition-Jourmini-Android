package com.example.giminitest.ui.page.map


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.giminitest.ui.theme.DialogScrim
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapTest(modifier: Modifier = Modifier) {
    val singapore = LatLng(1.35, 103.87)
    val state = remember { MarkerState(position = singapore) }
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }
    Box(
        modifier = modifier
            .background(color = DialogScrim)
            .fillMaxSize()
            .aspectRatio(0.7f)
            .padding(28.dp)
            .clip(RoundedCornerShape(28.dp))
            .clickable(enabled = false) {  }
            .background(AlertDialogDefaults.containerColor)
            .padding(24.dp)
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = state,
                title = "Singapore",
                snippet = "Marker in Singapore"
            )
        }

//        Spacer(modifier = Modifier.fillMaxSize().background(Color.Red))

        HollowRoundRectCanvas()
    }
}

@Composable
fun HollowRoundRectCanvas(
    backgroundColor: Color = AlertDialogDefaults.containerColor,
    roundedCornerSize: Dp = 28.dp
) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        // 圓角鏤空區塊的大小和位置
        val left = (canvasWidth - canvasWidth) / 2
        val top = (canvasHeight - canvasHeight) / 2
        val cornerRadius = CornerRadius(roundedCornerSize.toPx(), roundedCornerSize.toPx())

        // 使用 Path 創建鏤空效果
        val path = Path().apply {
            // 添加全屏矩形
            addRect(Rect(0f, 0f, canvasWidth, canvasHeight))
            // 添加圓角矩形的鏤空區域
            addRoundRect(
                RoundRect(
                    left = left,
                    top = top,
                    right = left + canvasWidth,
                    bottom = top + canvasHeight,
                    topLeftCornerRadius = cornerRadius,
                    topRightCornerRadius = cornerRadius,
                    bottomRightCornerRadius = cornerRadius,
                    bottomLeftCornerRadius = cornerRadius
                )
            )
            fillType = PathFillType.EvenOdd // 使用 EvenOdd 來創建鏤空區域
        }

        // 繪製 Path 來創建鏤空效果
        drawPath(
            path = path,
            color = backgroundColor, // 填充背景色
            style = Fill
        )
    }
}