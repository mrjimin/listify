package kr.mrjimin.listify.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { auth ->
                auth.requestMatchers("/", "/api/**", "/index.html", "/assets/**", "/static/**", "/favicon.ico").permitAll()
                auth.anyRequest().authenticated()
            }
            .oauth2Login { oauth ->
                oauth.defaultSuccessUrl("/main", true)
            }
            .logout { logout ->
                logout.logoutSuccessUrl("/")
                logout.invalidateHttpSession(true)
                logout.deleteCookies("JSESSIONID")
            }
            .csrf { it.disable() }
        return http.build()
    }
}