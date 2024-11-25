package com.ev.badchar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ev.badchar.list.BadCharListContent
import com.ev.badchar.ui.theme.BadCharCleanComposeAppTheme

@Composable
internal fun BadCharMainActivityContent() {
    BadCharCleanComposeAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                BadCharNavGraph()
            }
        }
    }
}

@Composable
private fun BadCharNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "badcharlist"
    ) {
        composable("badcharlist") {
            BadCharListContent()
        }
    }
}