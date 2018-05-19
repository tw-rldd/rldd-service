package com.thoughtworks.rldd.service.web.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class SecurityConfiguration : WebSecurityConfigurerAdapter() {

  override fun configure(http: HttpSecurity) {
    http
        .authorizeRequests()
        .anyRequest().permitAll()
  }
}