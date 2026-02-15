package kr.mrjimin.listify.controller

import kr.mrjimin.listify.service.SpotifyAPIService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest

@RestController
@RequestMapping("/api")
class AuthController(
    private val spotifyAPIUtil: SpotifyAPIService,
) {

//    @GetMapping("/token")
//    @ResponseBody
//    fun token(): String {
//        val authorizationCodeCredentials =
//    }

    @GetMapping("/login")
    @ResponseBody
    fun login(): String {
        val authorizationCodeUriRequest: AuthorizationCodeUriRequest = spotifyAPIUtil.spotifyAPI.authorizationCodeUri()
            .scope("user-read-birthdate,user-read-email")
            .show_dialog(true)
            .build()
        val uri = authorizationCodeUriRequest.execute()
        return uri.toString()
    }
}