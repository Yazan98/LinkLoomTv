package com.yazantarifi.linkloom.tv

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.yazantarifi.linkloom.tv.screens.HomeScreen
import com.yazantarifi.linkloom.tv.screens.OnBoardingScreen
import com.yazantarifi.linkloom.tv.utils.LinkLoomPrefsManager
import com.yazantarifi.linkloom.tv.utils.LinkLoomTheme
import com.yazantarifi.linkloom.tv.utils.RedPrimary

class MainScreen: ComponentActivity() {

    @OptIn(ExperimentalTvMaterial3Api::class, ExperimentalGlideComposeApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LinkLoomTheme {
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
        }

        Handler(Looper.getMainLooper()).postDelayed({
            onMainScreenNavigation()
        }, 3000)
    }

    private fun onMainScreenNavigation() {
        when (LinkLoomPrefsManager.getBooleanValue(applicationContext, LinkLoomPrefsManager.IS_FIRST_RUN_APP)) {
            true -> startActivity(Intent(this, HomeScreen::class.java))
            false -> startActivity(Intent(this, OnBoardingScreen::class.java))
        }
    }

}
