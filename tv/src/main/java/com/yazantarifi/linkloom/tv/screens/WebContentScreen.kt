package com.yazantarifi.linkloom.tv.screens

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.yazantarifi.linkloom.tv.LinkLoomApplication
import com.yazantarifi.linkloom.tv.R
import com.yazantarifi.linkloom.tv.content.SettingsItemsBuilder

class WebContentScreen : AppCompatActivity() {

    private var webView: WebView? = null

    companion object {
        private const val ARGUMENT_TYPE = "type"

        fun startScreen(context: Context, type: String) {
            Intent(context, WebContentScreen::class.java).apply {
                putExtra(ARGUMENT_TYPE, type)
                context.startActivity(this)
            }
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val type = intent?.extras?.getString(ARGUMENT_TYPE, "") ?: ""
        LinkLoomApplication.onSendScreenViewEvent("WebContentScreen_$type", this)
        setContentView(R.layout.screen_webview)
        webView = findViewById(R.id.webView)
        webView?.apply {
            settings.allowContentAccess = true
            settings.allowFileAccess = true
            settings.databaseEnabled = true
            settings.domStorageEnabled = true
            settings.loadsImagesAutomatically = true
            settings.javaScriptEnabled = true
            settings.userAgentString = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36"
            settings.setSupportZoom(true)

            val text = if (type == "terms") {
                SettingsItemsBuilder.getTermsAndConditions()
            } else {
                SettingsItemsBuilder.getPrivacyPolicy()
            }

            this.loadData(text, "text/html; charset=utf-8", "UTF-8")
        }
    }


}