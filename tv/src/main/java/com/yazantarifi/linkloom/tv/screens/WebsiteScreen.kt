package com.yazantarifi.linkloom.tv.screens

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.yazantarifi.linkloom.tv.R

class WebsiteScreen: AppCompatActivity() {

    private var webView: WebView? = null

    companion object {
        private const val ARGUMENT_URL = "url"
        private const val ARGUMENT_NAME = "name"

        fun startScreen(context: Context, url: String, name: String) {
            Intent(context, WebsiteScreen::class.java).apply {
                putExtra(ARGUMENT_NAME, name)
                putExtra(ARGUMENT_URL, "https://$url")
                context.startActivity(this)
            }
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val url = intent?.extras?.getString(ARGUMENT_URL, "") ?: ""
        val name = intent?.extras?.getString(ARGUMENT_NAME, "") ?: ""
        if (TextUtils.isEmpty(url) || TextUtils.isEmpty(name)) {
            finish()
            return
        }

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

            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    view?.loadUrl(url)
                    return true
                }
            }

            loadUrl(url)
        }
    }

    override fun onBackPressed() {
        if (webView?.canGoBack() == true) {
            webView?.goBack()
        } else {
            super.onBackPressed()
        }
    }

}