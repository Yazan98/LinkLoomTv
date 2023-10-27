package com.yazantarifi.linkloom.tv.utils

import android.content.Context
import com.yazantarifi.linkloom.tv.R
import com.yazantarifi.linkloom.tv.models.HomeSection
import com.yazantarifi.linkloom.tv.models.HomeSectionItem

object HomeScreenSectionsBuilder {

    fun getSections(context: Context): List<HomeSection> {
        return arrayListOf(
            HomeSection(context.getString(R.string.streaming), getStreamingItems(context)),
            HomeSection(context.getString(R.string.shopping), getShoppingItems(context)),
            HomeSection(context.getString(R.string.social_media), getSocialMediaItems(context)),
            HomeSection(context.getString(R.string.news), getNewsItems(context)),
            HomeSection(context.getString(R.string.most_popular), getMostPopularItems(context)),
            HomeSection(context.getString(R.string.programming), getProgrammingItems(context)),
        )
    }

    private fun getStreamingItems(context: Context): List<HomeSectionItem> {
        return arrayListOf(
            getWebsiteInstance("www.youtube.com", context.getString(R.string.youtube), R.drawable.banner_youtube),
            getWebsiteInstance("www.twitch.com", context.getString(R.string.twitch), R.drawable.banner_twitch),
            getWebsiteInstance("www.vimeo.com", context.getString(R.string.vimeo), R.drawable.banner_vimeo),
            getWebsiteInstance("www.netflix.com", context.getString(R.string.netflix), R.drawable.banner_netflix),
            getWebsiteInstance("www.hulu.com", context.getString(R.string.hulu), R.drawable.banner_hulu),
            getWebsiteInstance("www.foxsports.com", context.getString(R.string.fox_sports), R.drawable.banner_fox_sports),
            getWebsiteInstance("www.hbo.com", context.getString(R.string.hbo), R.drawable.banner_hbo),
        )
    }

    private fun getSocialMediaItems(context: Context): List<HomeSectionItem> {
        return arrayListOf(
            getWebsiteInstance("www.facebook.com", context.getString(R.string.facebook), R.drawable.banner_facebook),
            getWebsiteInstance("web.whatsapp.com", context.getString(R.string.whatsapp), R.drawable.banner_wp),
            getWebsiteInstance("www.instagram.com", context.getString(R.string.instagram), R.drawable.banner_instagram),
            getWebsiteInstance("www.wechat.com", context.getString(R.string.wechat), R.drawable.banner_wechat),
            getWebsiteInstance("www.tiktok.com", context.getString(R.string.tiktok), R.drawable.banner_tiktok),
            getWebsiteInstance("www.telegram.com", context.getString(R.string.telegram), R.drawable.banner_telegram),
            getWebsiteInstance("www.reddit.com", context.getString(R.string.reddit_videos), R.drawable.banner_reddit)
        )
    }

    private fun getShoppingItems(context: Context): List<HomeSectionItem> {
        return arrayListOf(
            getWebsiteInstance("www.amazon.com", context.getString(R.string.amazon), R.drawable.banner_amazon),
            getWebsiteInstance("www.ebay.com", context.getString(R.string.ebay), R.drawable.banner_ebay),
            getWebsiteInstance("www.apple.com", context.getString(R.string.apple), R.drawable.banner_apple),
        )
    }

    private fun getNewsItems(context: Context): List<HomeSectionItem> {
        return arrayListOf(
            getWebsiteInstance("www.cnn.com", context.getString(R.string.cnn), R.drawable.banner_cnn),
            getWebsiteInstance("abcnews.go.com", context.getString(R.string.abc_news), R.drawable.banner_bbc_news),
            getWebsiteInstance("www.nytimes.com", context.getString(R.string.ny_times), R.drawable.banner_ny_times),
            getWebsiteInstance("news.google.com", context.getString(R.string.google_news), R.drawable.banner_google_news),
            getWebsiteInstance("www.bbc.com", context.getString(R.string.bbc), R.drawable.banner_bbc),
        )
    }

    private fun getMostPopularItems(context: Context): List<HomeSectionItem> {
        return arrayListOf(
            getWebsiteInstance("www.google.com", context.getString(R.string.google), R.drawable.banner_google),
            getWebsiteInstance("www.bing.com", context.getString(R.string.bing), R.drawable.banner_bing),
        )
    }

    private fun getProgrammingItems(context: Context): List<HomeSectionItem> {
        return arrayListOf(
            getWebsiteInstance("www.github.com", context.getString(R.string.github), R.drawable.banner_github),
            getWebsiteInstance("www.stackoverflow.com", context.getString(R.string.stackoverflow), R.drawable.banner_stackoverflow),
            getWebsiteInstance("business.hackernoon.com", context.getString(R.string.hackernoon), R.drawable.banner_hackernoon),
        )
    }

    private fun getWebsiteInstance(url: String, name: String, banner: Int): HomeSectionItem {
        return HomeSectionItem(name, banner, url)
    }

}