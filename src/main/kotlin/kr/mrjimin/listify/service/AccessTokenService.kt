package kr.mrjimin.listify.service

import com.fasterxml.jackson.annotation.JsonProperty
import kr.mrjimin.listify.config.SpotifyProperties
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.postForEntity

data class AccessTokenDTO(
    @JsonProperty("access_token")
    val accessToken: String,
    @JsonProperty("token_type")
    val tokenType: String,
    @JsonProperty("expires_in")
    val expiresIn: Int
)

@Service
class AccessTokenService(
    private val spotifyProperties: SpotifyProperties,
    private val restTemplate: RestTemplate
) {

    private val URL = "https://accounts.spotify.com/api/token"

    fun getAccessToken(): AccessTokenDTO {
        val headers = HttpHeaders().apply {
            contentType = MediaType.APPLICATION_FORM_URLENCODED
        }

        val formData = LinkedMultiValueMap<String, String>().apply {
            add("grant_type", "client_credentials")
            add("client_id", spotifyProperties.clientId)
            add("client_secret", spotifyProperties.clientSecret)
        }

        val request = HttpEntity(formData, headers)
        val response = restTemplate.postForEntity<AccessTokenDTO>(
            URL,
            request
        )

        return if (response.statusCode.is2xxSuccessful) {
            response.body!!
        } else {
            throw IllegalStateException("Error: ${response.statusCode}")
        }

    }


//        val headers = HttpHeaders().apply {
//            contentType = MediaType.APPLICATION_FORM_URLENCODED
//        }
//
//        val map: MultiValueMap<String, String> = LinkedMultiValueMap()
//
//        map["grant_type"] = "authorization_code"
//        map["client_id"] = spotifyProperties.clientId
//        map["client_secret"] = spotifyProperties.clientSecret
//
//        val request: HttpEntity<MultiValueMap<String, String>> = HttpEntity(map, headers)
//        val response: ResponseEntity<AccessTokenDto> =
//            restTemplate.postForEntity<AccessTokenDto>(URL, request)
//
//        return response.body?.accessToken ?: "null"

//        val clientCredentialsRequest: ClientCredentialsRequest = spotifyAPIService.spotifyAPI.clientCredentials().build()
//
//        val clientCredentials: ClientCredentials = clientCredentialsRequest.execute()
//        spotifyAPIService.spotifyAPI.accessToken = clientCredentials.accessToken
//
//        println(clientCredentials.accessToken)
//
//        return spotifyAPIService.spotifyAPI.accessToken



}