package com.thoughtworks.rldd.service.contracts

import com.thoughtworks.rldd.service.member.MemberApplicationService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import spock.mock.DetachedMockFactory

@Configuration
class WebMvcTestConfiguration {

    private def detachedMockFactory = new DetachedMockFactory()

    @Bean
    MemberApplicationService userApplicationService() {
        detachedMockFactory.Mock(MemberApplicationService)
    }

}
