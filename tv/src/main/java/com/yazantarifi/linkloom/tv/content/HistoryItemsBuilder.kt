package com.yazantarifi.linkloom.tv.content

import android.content.Context
import com.yazantarifi.linkloom.tv.R
import com.yazantarifi.linkloom.tv.models.HomeSection
import com.yazantarifi.linkloom.tv.models.HomeSectionItem

object HistoryItemsBuilder {

    fun getScreenItems(context: Context): List<HomeSection> {
        return arrayListOf(
            HomeSection(context.getString(R.string.history), getHistoryItems(context))
        )
    }

    private fun getHistoryItems(context: Context): List<HomeSectionItem> {
        return arrayListOf(
            getWebsiteInstance("add", context.getString(R.string.add_website), R.drawable.banner_add_new),
            getWebsiteInstance("clear", context.getString(R.string.clear_history), R.drawable.banner_clear_new),
        )
    }

    private fun getWebsiteInstance(url: String, name: String, banner: Int): HomeSectionItem {
        return HomeSectionItem(name, banner, url)
    }

}