package com.yazantarifi.linkloom.tv.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import com.yazantarifi.linkloom.tv.utils.RedPrimary
import com.yazantarifi.linkloom.tv.utils.White

class AboutAppScreen: ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
            ) {
                Text(text = "Application Information", color = RedPrimary)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "This screen Contains Application Tech Information", color = White)
                Spacer(modifier = Modifier.height(40.dp))
                Text(text = "Technologies Used in This Application", color = White)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "1. Jetpack Compose Tv", color = White)
                Text(text = "2. Timber Logging", color = White)
                Text(text = "3. Firebase Reporting", color = White)
                Text(text = "4. Material 3 Jetpack Compose Library", color = White)
                Text(text = "5. Realm Local Storage", color = White)
                Text(text = "6. K2 Kotlin Compiler", color = White)
            }
        }
    }
}
