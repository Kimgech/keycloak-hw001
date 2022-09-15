package com.example.webfluxdemo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.config.web.server.invoke
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun filterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http.invoke{
            cors{}
            csrf{ disable() }
            authorizeExchange{
                authorize("/api/v1/instance**", authenticated)
                authorize("/api/v1/os**", authenticated)

            }
            oauth2ResourceServer {
                jwt {}
            }
        }
    }
}