package com.yazantarifi.linkloom.tv.utils

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.darkColorScheme
import androidx.tv.material3.lightColorScheme

val RedPrimary = Color(0xFFE14B4B)
val RedPrimaryDark = Color(0xFFB62321)
val RedAccent = Color(0xFFE14B4B)
val White = Color(0xFFFFFFFF)

@OptIn(ExperimentalTvMaterial3Api::class)
val RedComposeColors = lightColorScheme(
    primary = RedPrimary,
    primaryContainer = RedPrimaryDark,
    secondary = RedAccent,
    secondaryContainer = RedAccent,
    background = Color(0xFF121212), // Dark background
    surface = Color.White, // Light surface
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.Black
)

@OptIn(ExperimentalTvMaterial3Api::class)
val RedComposeColorsDark = darkColorScheme(
    primary = RedPrimary,
    primaryContainer = RedPrimaryDark,
    secondary = RedAccent,
    secondaryContainer = RedAccent,
    background = Color(0xFF121212), // Dark background
    surface = Color.White, // Light surface
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.Black
)

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun LinkLoomTheme(content: @Composable () -> Unit) {
    val isDark = isSystemInDarkTheme()
    val colors = if (isDark) {
        RedComposeColorsDark
    } else {
        RedComposeColors
    }


    MaterialTheme(
        content = content,
        colorScheme = colors
    )
}

