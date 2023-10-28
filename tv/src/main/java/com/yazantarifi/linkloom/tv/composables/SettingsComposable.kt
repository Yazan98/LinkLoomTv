package com.yazantarifi.linkloom.tv.composables

import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.items
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import com.yazantarifi.linkloom.tv.R
import com.yazantarifi.linkloom.tv.content.SettingsItemsBuilder
import com.yazantarifi.linkloom.tv.models.SettingsItem
import com.yazantarifi.linkloom.tv.screens.AboutAppScreen
import com.yazantarifi.linkloom.tv.screens.WebContentScreen
import com.yazantarifi.linkloom.tv.screens.WebsiteScreen
import com.yazantarifi.linkloom.tv.utils.RedPrimary
import com.yazantarifi.linkloom.tv.utils.White


@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun SettingsComposable() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .padding(end = 20.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = context.getString(R.string.settings),
            fontSize = TextUnit(18f, TextUnitType.Sp),
            color = RedPrimary
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = context.getString(R.string.settings_message),
            fontSize = TextUnit(18f, TextUnitType.Sp),
            color = White
        )

        Spacer(modifier = Modifier.height(20.dp))

        TvLazyColumn(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            items(SettingsItemsBuilder.getItems(context)) { section ->
                if (section.key.isNotEmpty()) {
                    SettingsOptionItem(section) {
                        if (section.key == "terms" || section.key == "privacy") {
                            WebContentScreen.startScreen(context, section.key)
                        } else if (section.key == "report" || section.key == "request") {
                            val url = "https://github.com/Yazan98/LinkLoomTv"
                            try {
                                val i = Intent("android.intent.action.MAIN")
                                i.component = ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main")
                                i.addCategory("android.intent.category.LAUNCHER")
                                i.data = Uri.parse(url)
                                context.startActivity(i)
                            } catch (e: ActivityNotFoundException) {
                                WebsiteScreen.startScreen(context, url.replace("https://", ""), "Personal Website")
                            }
                        } else if (section.key == "accounts") {
                            Toast.makeText(context, context.getString(R.string.under_dev), Toast.LENGTH_LONG).show()
                        } else {
                            context.startActivity(Intent(context, AboutAppScreen::class.java))
                        }
                    }
                } else {
                    SettingsFooterComposable()
                }
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun SettingsFooterComposable() {
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(id = R.string.settings_1), color = RedPrimary,  textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = stringResource(id = R.string.settings_2), color = White, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = stringResource(id = R.string.settings_3), textAlign = TextAlign.Center, color = RedPrimary)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "App Version : 1.0", color = White)
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun SettingsOptionItem(item: SettingsItem, onOptionClickListener: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onOptionClickListener(item.key) }
    ) {
        Text(
            text = item.name,
            color = White,
            fontSize = TextUnit(15f, TextUnitType.Sp)
        )
        Spacer(modifier = Modifier.height(35.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(White))
    }
}