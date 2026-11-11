package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.referral.ReferralBanner

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {
            ReferralBanner()
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp)) {
            Text("Welcome to Edu Gura!", style = MaterialTheme.typography.headlineMedium)
        }
    }
}
