package com.example.giminitest.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.giminitest.ui.page.map.MapTest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalSheetMap(
    state: SheetState,
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = { /*TODO*/ }
) {
//    ModalBottomSheet(
//        onDismissRequest = onDismissRequest, sheetState = state,
////        properties =
//    ) {
//    }

    BottomSheetScaffold(
        { Spacer(modifier = Modifier.fillMaxSize().background(Color.Blue)) },
//        sheetSwipeEnabled = false
    ) {
        Spacer(modifier = Modifier.fillMaxSize().background(Color.Red))
    }
}