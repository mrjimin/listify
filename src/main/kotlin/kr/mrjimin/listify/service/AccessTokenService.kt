package kr.mrjimin.listify.service

import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class AccessTokenService(
    restTemplate: RestTemplate,
) {

    private val URL = "https://accounts.spotify.com/api/token"

    fun getAccessToken(code: String): String {
        HttpHeaders().apply {
            contentType = MediaType.APPLICATION_FORM_URLENCODED
        }


        return ""
    }

}