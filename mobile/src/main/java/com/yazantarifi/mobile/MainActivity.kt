package com.yazantarifi.mobile

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.yazantarifi.linkloom.mobile.R
import com.yazantarifi.mobile.screens.HomeScreen

val RedPrimary = Color(0xFFE14B4B)

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalGlideComposeApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize().background(RedPrimary),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GlideImage(
                    model = R.mipmap.ic_launcher,
                    contentDescription = "Application Logo",
                    modifier = Modifier.size(70.dp)
                )
            }
        }

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@MainActivity, HomeScreen::class.java))
            finish()
        }, 3000)
    }
}
