package kr.mrjimin.listify.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CORSConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            // .allowedOrigins("http://localhost:5173")
            // .allowedOrigins("https://listify7.vercel.app/")
            .allowedOrigins(
                "https://listify.life",
                "https://listify7.vercel.app",
                "http://localhost:5173"
            )
            .allowedMethods("*")
            .allowCredentials(true)
    }
}