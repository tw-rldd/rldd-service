package com.thoughtworks.rldd.service.contracts

import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print

@Configuration
class MockMvcBuilderCustomizers {

    @Bean
    MockMvcBuilderCustomizer alwaysPrint() {
        { builder -> builder.alwaysDo(print()) }
    }

}
