package com.yazantarifi.linkloom.tv

import android.text.TextUtils
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yazantarifi.linkloom.tv.database.ApplicationDatabase
import com.yazantarifi.linkloom.tv.models.HomeSection
import com.yazantarifi.linkloom.tv.models.HomeSectionItem
import com.yazantarifi.linkloom.tv.models.database.LinkHistoryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ApplicationViewModel: ViewModel() {

    val historyScreenItems = mutableStateListOf<LinkHistoryEntity>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            ApplicationDatabase().getHistoryItems().let {
                launch(Dispatchers.Main) {
                    historyScreenItems.addAll(it)
                }
            }
        }
    }

    fun onClearHistory(accountName: String) {
        historyScreenItems.clear()
        viewModelScope.launch(Dispatchers.IO) {
            ApplicationDatabase().onClearHistory(accountName)
        }
    }

    fun onSaveNewUrl(inputName: String, inputUrl: String, profileName: String) {
        if (TextUtils.isEmpty(inputName) || TextUtils.isEmpty(inputUrl)) {
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            val newEntity = LinkHistoryEntity().apply {
                primaryKey = "$profileName:$inputUrl"
                name = inputName
                url = inputUrl
                account = profileName
            }

            historyScreenItems.add(0, newEntity)
            ApplicationDatabase().insertEntity(newEntity)
        }
    }

}
