package kr.mrjimin.listify.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import se.michaelthelin.spotify.SpotifyApi
import se.michaelthelin.spotify.SpotifyHttpManager

@Configuration
class SpotifyConfig {

    @Bean
    fun spotifyApi(properties: SpotifyProperties): SpotifyApi {
        val redirectURI = SpotifyHttpManager.makeUri(properties.redirectUri)
        return SpotifyApi.builder()
            .setClientId(properties.clientId)
            .setClientSecret(properties.clientSecret)
            .setRedirectUri(redirectURI)
            .build()
    }
}