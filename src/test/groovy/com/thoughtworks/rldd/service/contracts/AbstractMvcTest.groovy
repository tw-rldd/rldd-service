package com.thoughtworks.rldd.service.contracts

import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

@WebMvcTest
@ComponentScan([
        "com.thoughtworks.rldd.service"
])
abstract class AbstractMvcTest extends Specification {

    @Autowired
    MockMvc mockMvc

    def setup() {
        RestAssuredMockMvc.mockMvc(this.mockMvc)
    }

}