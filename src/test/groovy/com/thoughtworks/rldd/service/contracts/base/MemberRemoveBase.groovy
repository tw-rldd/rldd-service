package com.thoughtworks.rldd.service.contracts.base

import com.thoughtworks.rldd.service.contracts.AbstractMvcTest
import com.thoughtworks.rldd.service.member.MemberApplicationService
import com.thoughtworks.rldd.service.member.model.Member
import org.springframework.beans.factory.annotation.Autowired

class MemberRemoveBase extends AbstractMvcTest {

    @Autowired
    MemberApplicationService memberApplicationService

    def setup() {
        memberApplicationService.removeBy("001") >> new Member('001', 'yusong.deng', 3)
    }
}
