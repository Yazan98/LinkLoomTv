package com.yazantarifi.mobile.screens

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.mediarouter.media.MediaControlIntent
import androidx.mediarouter.media.MediaRouteSelector
import androidx.mediarouter.media.MediaRouter
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.google.android.gms.cast.Cast.MessageReceivedCallback
import com.google.android.gms.cast.CastDevice
import com.google.android.gms.cast.CastMediaControlIntent
import com.google.android.gms.cast.CastStatusCodes
import com.google.android.gms.cast.framework.CastSession
import com.google.android.gms.cast.framework.SessionManager
import com.google.android.gms.cast.framework.SessionManagerListener
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.yazantarifi.linkloom.mobile.R
import com.yazantarifi.mobile.LinkLoomApplication
import com.yazantarifi.mobile.LinkLoomChromeCastDevice
import com.yazantarifi.mobile.RedPrimary


class HomeScreen: ComponentActivity() {

    private var currentUrl = ""
    private var connectedDevice: String = ""
    private var castSession: CastSession? = null
    private lateinit var mediaRouter: MediaRouter
    private var mediaSelector: MediaRouteSelector? = null
    private var connectedDeviceState by mutableStateOf("")
    private val chromecastDevicesState by lazy { mutableStateListOf<LinkLoomChromeCastDevice>() }

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .padding(30.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Link Loom Mobile Application", color = RedPrimary)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Share Websites Links Directly to TV", color = Color.White)
                }
                
                Column(modifier = Modifier.fillMaxWidth()) {
                    var websiteLink by remember { mutableStateOf("") }
                    OutlinedTextField(modifier = Modifier.fillMaxWidth(), value = websiteLink, onValueChange = {
                        websiteLink = it
                    }, placeholder = {
                        Text(text = "Example (www.example.com)")
                    }, label = {
                        Text(text = "Website Url", color = RedPrimary)
                    }, colors = TextFieldDefaults.textFieldColors(focusedTextColor = Color.Black))

                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        modifier = Modifier,
                        onClick = {
                            if (websiteLink.isNotEmpty()) {
                                currentUrl = websiteLink
                                castSession?.sendMessage("urn:x-cast:open-website", websiteLink)
                            }
                        }
                    ) {
                        Text(text = getString(R.string.add_new), color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Select a Device To Connect", color = Color.White)
                    Spacer(modifier = Modifier.height(5.dp))
                    LazyColumn(modifier = Modifier.fillMaxWidth()) {
                        items(chromecastDevicesState) {
                            Column( modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    if (connectedDeviceState.isEmpty()) {
                                        mediaSelector?.let { it1 ->
                                            mediaRouter.addCallback(
                                                it1, mediaRouterCallback,
                                                MediaRouter.CALLBACK_FLAG_PERFORM_ACTIVE_SCAN)
                                        }
                                        Toast.makeText(this@HomeScreen, "Device Connection Started", Toast.LENGTH_SHORT).show()
                                        mediaRouter.selectRoute(it.routeDevice)
                                    }
                                }) {
                                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {

                                    GlideImage(model = R.drawable.chromecast, contentDescription = "Device Icon", modifier = Modifier.size(30.dp))
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Column {
                                        Text(text = it.name, color = Color.White, modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(5.dp))
                                        Text(text = it.id, color = Color.White, modifier = Modifier
                                            .fillMaxWidth())
                                    }
                                }

                                Spacer(modifier = Modifier.height(10.dp))
                                Divider()
                            }
                        }
                    }
                }

                var result by remember { mutableStateOf(connectedDeviceState) }
                LaunchedEffect(connectedDeviceState) {
                    result = connectedDeviceState
                }

                Column(modifier = Modifier.fillMaxWidth()) {
                    if (result.isNotEmpty()) {
                        Text(text = "Chromecast Connected", color = Color.Green)
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Link Loom Work only with Link Loom TV Application", color = Color.White)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Make Sure All Devices Connected to Same Network", color = Color.Gray)
                }
            }
        }


        mediaSelector = MediaRouteSelector.Builder()
            .addControlCategory(MediaControlIntent.CATEGORY_REMOTE_PLAYBACK)
            .addControlCategory(CastMediaControlIntent.categoryForCast("07EB8A95"))
            .build()

        mediaRouter = MediaRouter.getInstance(applicationContext)
        val routes = mediaRouter.routes;
        routes.forEach {
            val device = CastDevice.getFromBundle(it.extras)
            if (!TextUtils.isEmpty(device?.deviceId ?: "")) {
                chromecastDevicesState.add(LinkLoomChromeCastDevice(device?.deviceId ?: "", device?.friendlyName ?: "", device?.deviceVersion ?: "", it))
            }
        }

        (applicationContext as LinkLoomApplication).castInstance?.sessionManager?.addSessionManagerListener(sessionManagerListener, CastSession::class.java)
    }

    override fun onStart() {
        super.onStart()
        mediaSelector?.also { selector ->
            mediaRouter.addCallback(selector, mediaRouterCallback,
                MediaRouter.CALLBACK_FLAG_PERFORM_ACTIVE_SCAN)
        }
    }

    private val mediaRouterCallback = object : MediaRouter.Callback() {
        override fun onRouteSelected(
            router: MediaRouter,
            route: MediaRouter.RouteInfo,
            reason: Int
        ) {
            super.onRouteSelected(router, route, reason)
            println("Charomcast Event : onRouteSelected : $route")
        }
    }

    private val sessionManagerListener = object : SessionManagerListener<CastSession> {
        override fun onSessionEnded(p0: CastSession, p1: Int) {
            println("Charomcast Event : onSessionEnded")
            connectedDevice = ""
            connectedDeviceState = ""
        }

        override fun onSessionEnding(p0: CastSession) {
            println("Charomcast Event : onSessionEnding")
            connectedDevice = ""
            connectedDeviceState = ""
        }

        override fun onSessionResumeFailed(p0: CastSession, p1: Int) {
            println("Charomcast Event : onSessionResumeFailed")
        }

        override fun onSessionResumed(p0: CastSession, p1: Boolean) {
            println("Charomcast Event : onSessionResumed")
        }

        override fun onSessionResuming(p0: CastSession, p1: String) {
            println("Charomcast Event : onSessionResuming")
        }

        override fun onSessionStartFailed(p0: CastSession, p1: Int) {
            println("Charomcast Event : onSessionStartFailed : ${ (applicationContext as LinkLoomApplication).castInstance?.getCastReasonCodeForCastStatusCode(p1)}")
            println("Charomcast Event : onSessionStartFailed : ${CastStatusCodes.getStatusCodeString(p1)}")
            connectedDevice = ""
            connectedDeviceState = ""
        }

        override fun onSessionStarted(p0: CastSession, p1: String) {
            println("Charomcast Event : onSessionStarted")
            castSession = p0
            connectedDeviceState = p0.sessionId ?: ""
            Toast.makeText(this@HomeScreen, "Device Connected", Toast.LENGTH_SHORT).show()
        }

        override fun onSessionStarting(p0: CastSession) {
            println("Charomcast Event : onSessionStarting")
        }

        override fun onSessionSuspended(p0: CastSession, p1: Int) {
            println("Charomcast Event : onSessionSuspended")
        }

    }

    override fun onPause() {
        super.onPause()
        (applicationContext as LinkLoomApplication).castInstance?.sessionManager?.removeSessionManagerListener(sessionManagerListener, CastSession::class.java)
    }

    override fun onResume() {
        super.onResume()
        (applicationContext as LinkLoomApplication).castInstance?.sessionManager?.addSessionManagerListener(sessionManagerListener, CastSession::class.java)
        castSession = (applicationContext as LinkLoomApplication).castInstance?.sessionManager?.currentCastSession
    }

}