package com.yazantarifi.linkloom.tv.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.tv.material3.DrawerState
import androidx.tv.material3.DrawerValue
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.NavigationDrawer
import androidx.tv.material3.NavigationDrawerItem
import androidx.tv.material3.NavigationDrawerItemColors
import androidx.tv.material3.NavigationDrawerItemShape
import androidx.tv.material3.NavigationDrawerScope
import androidx.tv.material3.Text
import androidx.tv.material3.rememberDrawerState
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.yazantarifi.linkloom.tv.ApplicationViewModel
import com.yazantarifi.linkloom.tv.LinkLoomApplication
import com.yazantarifi.linkloom.tv.R
import com.yazantarifi.linkloom.tv.composables.HistoryTabComposable
import com.yazantarifi.linkloom.tv.composables.HomeTabComposable
import com.yazantarifi.linkloom.tv.composables.SettingsComposable
import com.yazantarifi.linkloom.tv.models.NavigationItem
import com.yazantarifi.linkloom.tv.utils.LinkLoomTheme
import com.yazantarifi.linkloom.tv.utils.RedPrimary
import com.yazantarifi.linkloom.tv.utils.RedPrimaryDark
import kotlinx.coroutines.launch

class HomeScreen: ComponentActivity() {

    private val viewModel: ApplicationViewModel by viewModels()

    @OptIn(ExperimentalTvMaterial3Api::class, ExperimentalGlideComposeApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LinkLoomApplication.onSendScreenViewEvent("HomeScreen", this)
        setContent {
            LinkLoomTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                var selectedNavigationIndex = remember { mutableIntStateOf(0) }
                NavigationDrawer(
                    drawerState = drawerState,
                    modifier = Modifier
                        .fillMaxHeight()
                        .background(Color.Black)
                        .padding(10.dp),
                    drawerContent = {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(10.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            NavigationItemComposable(drawerState, 0, NavigationItem(R.drawable.home, getString(R.string.home)), selectedNavigationIndex)
                            NavigationItemComposable(drawerState, 1, NavigationItem(R.drawable.history, getString(R.string.history)), selectedNavigationIndex)
                            NavigationItemComposable(drawerState, 2, NavigationItem(R.drawable.settings, getString(R.string.settings)), selectedNavigationIndex)
                        }
                    }
                ) {
                    ScreenContent(selectedNavigationIndex.intValue)
                }
            }
        }
    }

    @OptIn(ExperimentalTvMaterial3Api::class)
    @Composable
    fun ScreenContent(position: Int) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
        ) {
            when (position) {
                0 -> HomeTabComposable()
                1 -> HistoryTabComposable(viewModel)
                2 -> SettingsComposable()
            }
        }
    }

    @OptIn(ExperimentalTvMaterial3Api::class, ExperimentalGlideComposeApi::class)
    @Composable
    fun NavigationDrawerScope.NavigationItemComposable(state: DrawerState, index: Int, item: NavigationItem, selectedNavigationIndex: MutableIntState) {
        val isSelected = selectedNavigationIndex.intValue == index
        val scope = rememberCoroutineScope()

        NavigationDrawerItem(
            selected = isSelected,
            onClick = {
                selectedNavigationIndex.intValue = index
                scope.launch {
                    state.setValue(DrawerValue.Closed)
                }
            },
            leadingContent = {
                GlideImage(model = item.icon, contentDescription = item.text, colorFilter = ColorFilter.tint(Color.White))
            },
            modifier = Modifier.padding(10.dp),
            colors = NavigationDrawerItemColors(
                focusedContainerColor = RedPrimary,
                focusedContentColor = Color.White,
                focusedSelectedContainerColor = RedPrimaryDark,
                focusedSelectedContentColor = Color.White,
                selectedContainerColor = RedPrimaryDark, // done
                selectedContentColor = Color.White,
                containerColor = Color.Black,
                contentColor = Color.White,
                inactiveContentColor = Color.White,
                pressedContainerColor = Color.Black,
                pressedContentColor = Color.White,
                disabledContainerColor = Color.Black,
                disabledContentColor = Color.Black,
                disabledInactiveContentColor = Color.Black,
                pressedSelectedContainerColor = Color.Black,
                pressedSelectedContentColor = Color.White
            )
        ) {
            Text(text = item.text, color = Color.White, softWrap = false)
        }
    }

}