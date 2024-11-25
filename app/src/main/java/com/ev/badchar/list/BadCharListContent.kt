package com.ev.badchar.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.ev.badchar.ui.composable.FullScreenLoading

@Composable
fun BadCharListContent() {
    val badCharListViewModel: BadCharListViewModel = hiltViewModel<BadCharListViewModel>()
    val scrollState = rememberLazyListState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0x80000000)),
        contentAlignment = Alignment.Center
    ) {
        when {
            badCharListViewModel.loadingVisible -> FullScreenLoading(
                stringResource(
                    badCharListViewModel.loadingMessage
                )
            )
             else -> Greeting("BadChar")
        }
    }
}

@Composable
private fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}