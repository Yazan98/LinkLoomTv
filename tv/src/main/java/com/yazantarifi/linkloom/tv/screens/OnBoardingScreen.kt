package com.yazantarifi.linkloom.tv.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Carousel
import androidx.tv.material3.CarouselDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.yazantarifi.linkloom.tv.R
import com.yazantarifi.linkloom.tv.models.OnBoardingItem
import com.yazantarifi.linkloom.tv.utils.LinkLoomTheme
import com.yazantarifi.linkloom.tv.utils.RedPrimary
import com.yazantarifi.linkloom.tv.utils.White

class OnBoardingScreen: ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LinkLoomTheme {
                val items = getOnBoardingItems()
                Carousel(
                    itemCount = items.size,
                    autoScrollDurationMillis = 7000,
                    contentTransformStartToEnd = ContentTransform(
                        targetContentEnter = EnterTransition.None,
                        initialContentExit = ExitTransition.None,
                        sizeTransform = SizeTransform()
                    ),
                    contentTransformEndToStart = ContentTransform(
                        targetContentEnter = EnterTransition.None,
                        initialContentExit = ExitTransition.None,
                        sizeTransform = SizeTransform()
                    ),
                    content = { index ->
                        items[index].also { item ->
                            ScreenItemComposable(item = item)
                        }
                    }
                )
            }
        }
    }

    @OptIn(ExperimentalGlideComposeApi::class, ExperimentalTvMaterial3Api::class)
    @Composable
    fun ScreenItemComposable(item: OnBoardingItem) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

                var visible by remember { mutableStateOf(true) }
                AnimatedVisibility(
                    visible,
                    enter = fadeIn(initialAlpha = 0.0f),
                    exit =  fadeOut()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(20.dp),
                        verticalArrangement = Arrangement.Center
                    ) {

                        Text(
                            text = item.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = TextUnit(20f, TextUnitType.Sp),
                            color = RedPrimary
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = item.message,
                            fontWeight = FontWeight.Normal,
                            fontSize = TextUnit(15f, TextUnitType.Sp),
                            color = White,
                            modifier = Modifier.fillMaxWidth(0.5f)
                        )
                    }
                }

            GlideImage(
                model = item.image,
                contentDescription = "On Boarding Image",
                Modifier
                    .size(500.dp, 300.dp)
                    .padding(10.dp),
                contentScale = ContentScale.Fit
            )
        }
    }

    private fun getOnBoardingItems(): List<OnBoardingItem> {
        return arrayListOf(
            OnBoardingItem(getString(R.string.on_boarding_1_title), getString(R.string.on_boarding_1_message), R.drawable.on_boarding_1),
            OnBoardingItem(getString(R.string.on_boarding_2_title), getString(R.string.on_boarding_2_message), R.drawable.on_boarding_2),
            OnBoardingItem(getString(R.string.on_boarding_3_title), getString(R.string.on_boarding_3_message), R.drawable.on_boarding_3),
        )
    }
}