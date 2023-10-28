package com.yazantarifi.mobile

import androidx.mediarouter.media.MediaRouter


data class LinkLoomChromeCastDevice(
    val id: String,
    val name: String,
    val version: String,
    val routeDevice: MediaRouter.RouteInfo
)