package com.yazantarifi.linkloom.tv.composables

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.items
import androidx.tv.material3.Button
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import com.yazantarifi.linkloom.tv.ApplicationViewModel
import com.yazantarifi.linkloom.tv.LinkLoomApplication
import com.yazantarifi.linkloom.tv.R
import com.yazantarifi.linkloom.tv.screens.HomeScreen
import com.yazantarifi.linkloom.tv.screens.WebsiteScreen
import com.yazantarifi.linkloom.tv.utils.HistoryItemsBuilder
import com.yazantarifi.linkloom.tv.utils.HomeScreenSectionsBuilder
import com.yazantarifi.linkloom.tv.utils.LinkLoomPrefsManager
import com.yazantarifi.linkloom.tv.utils.RedPrimary
import com.yazantarifi.linkloom.tv.utils.White

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun HistoryTabComposable(viewModel: ApplicationViewModel) {
    val context = LocalContext.current
    val isAddInputDialogOpened = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .padding(end = 20.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = context.getString(R.string.history_title),
            fontSize = TextUnit(18f, TextUnitType.Sp),
            color = RedPrimary
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = context.getString(R.string.history_message),
            fontSize = TextUnit(18f, TextUnitType.Sp),
            color = White
        )

        Spacer(modifier = Modifier.height(20.dp))

        TvLazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            items(HistoryItemsBuilder.getScreenItems(context)) { section ->
                Section(section) {
                    if (it.url.equals("add")) {
                        isAddInputDialogOpened.value = true
                    } else {
                        viewModel.historyScreenItems.clear()
                    }
                }
            }
        }

        if (isAddInputDialogOpened.value) {
            Dialog(onDismissRequest = {
                isAddInputDialogOpened.value = false
            }) {
                Surface(
                    modifier = Modifier
                        .width(400.dp)
                        .wrapContentHeight(),
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = context.getString(R.string.add_dialog_message))
                        Spacer(modifier = Modifier.height(10.dp))

                        var websiteName by rememberSaveable { mutableStateOf("") }
                        var websiteUrl by rememberSaveable { mutableStateOf("") }

                        Text(text = context.getString(R.string.name))
                        Spacer(modifier = Modifier.height(3.dp))
                        BasicTextField(
                            value = websiteName,
                            onValueChange = { websiteName = it },
                            singleLine = true,
                            maxLines = 1,
                            keyboardOptions = KeyboardOptions(
                                imeAction = ImeAction.Next,
                                keyboardType = KeyboardType.Text
                            ),
                        )

                        Spacer(modifier = Modifier.height(15.dp))
                        Text(text = context.getString(R.string.url))
                        Spacer(modifier = Modifier.height(3.dp))
                        BasicTextField(
                            value = websiteUrl,
                            onValueChange = { websiteUrl = it },
                            singleLine = true,
                            maxLines = 1,
                            keyboardOptions = KeyboardOptions(
                                imeAction = ImeAction.Done,
                                keyboardType = KeyboardType.Text
                            ),
                        )

                        Spacer(modifier = Modifier.height(25.dp))
                        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                            Button(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(RedPrimary),
                                onClick = {
                                    viewModel.onSaveNewUrl(websiteName, websiteUrl, (context.applicationContext as LinkLoomApplication).currentProfile)
                                    isAddInputDialogOpened.value = false
                                }
                            ) {
                                Text(text = context.getString(R.string.save), color = White)
                            }

                            Spacer(modifier = Modifier.width(20.dp))

                            Button(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(RedPrimary),
                                onClick = {
                                    isAddInputDialogOpened.value = false
                                }
                            ) {
                                Text(text = context.getString(R.string.cancel), color = White)
                            }
                        }
                    }
                }
            }
        }
    }
}