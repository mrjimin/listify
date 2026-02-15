package kr.mrjimin.listify.service

import kr.mrjimin.listify.configuration.SpotifyProperties
import org.springframework.stereotype.Service
import se.michaelthelin.spotify.SpotifyApi
import se.michaelthelin.spotify.SpotifyHttpManager

@Service
class SpotifyAPIService(
    spotifyProperties: SpotifyProperties,
) {

    private val redirectURI = SpotifyHttpManager.makeUri(spotifyProperties.redirectUri)
    val spotifyAPI: SpotifyApi = SpotifyApi.builder()
        .setClientId(spotifyProperties.clientId)
        .setClientSecret(spotifyProperties.clientSecret)
        .setRedirectUri(redirectURI)
        .build()

//    val authorizationCodeRequest: AuthorizationCodeRequest = spotifyAPI.authorizationCodeRefresh()
//        .build()
}