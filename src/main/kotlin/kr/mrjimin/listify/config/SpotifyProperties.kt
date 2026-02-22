package kr.mrjimin.listify.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "spotify")
data class SpotifyProperties(
    val clientId: String,
    val clientSecret: String,
    val redirectUri: String
)
