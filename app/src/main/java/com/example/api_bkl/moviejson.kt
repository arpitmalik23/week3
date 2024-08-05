package com.example.api_bkl

data class moviejson(
    val android_playstore_url: Any,
    val android_scheme: Any,
    val id: Int,
    val ios_appstore_url: Any,
    val ios_scheme: String,
    val logo_100px: String,
    val name: String,
    val regions: List<String>,
    val type: String
)