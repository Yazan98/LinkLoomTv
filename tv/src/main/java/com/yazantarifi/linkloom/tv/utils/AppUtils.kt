package com.yazantarifi.linkloom.tv.utils

import androidx.compose.ui.graphics.Color

object AppUtils {

    private val materialColors = listOf(
        Color(0xFF6200EA),  // Purple 500
        Color(0xFF03DAC6),  // Teal 200
        Color(0xFFBB86FC),  // Deep Purple 200
        Color(0xFFFFAC33),  // Amber 500
        Color(0xFFFF6E40),  // Deep Orange 400
        Color(0xFFFF7043),  // Deep Orange 300
        Color(0xFF0097A7),  // Cyan 600
        Color(0xFF1E88E5),  // Blue 600
        Color(0xFF64DD17),  // Light Green 600
        Color(0xFFC2185B),  // Pink 900
        Color(0xFF607D8B),  // Blue Grey 500
        Color(0xFFFF5252),  // Red 300
        Color(0xFFA67C52),  // Brown 400
        Color(0xFF00E676),  // Light Green 500
        Color(0xFF2E7D32)   // Green 900
    )

    fun getRandomMaterialColor(): Color {
        val randomIndex = (materialColors.indices).random()
        return materialColors[randomIndex]
    }
}