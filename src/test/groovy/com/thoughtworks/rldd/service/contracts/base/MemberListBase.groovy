package com.thoughtworks.rldd.service.contracts.base

import com.thoughtworks.rldd.service.contracts.AbstractMvcTest
import com.thoughtworks.rldd.service.member.MemberApplicationService
import com.thoughtworks.rldd.service.member.model.User
import org.springframework.beans.factory.annotation.Autowired

class MemberListBase extends AbstractMvcTest {

    @Autowired
    MemberApplicationService memberApplicationService

    @Override
    def setup() {
        memberApplicationService.retrieveAll() >> (1..3).collect { new User('001', 'yusong.deng', 3) }
    }
}
