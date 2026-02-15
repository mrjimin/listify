package kr.mrjimin.listify.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "spotify")
data class SpotifyProperties(
    val clientId: String,
    val clientSecret: String,
    val redirectUri: String
)
