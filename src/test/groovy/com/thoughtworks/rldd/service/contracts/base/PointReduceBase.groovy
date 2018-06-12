package com.thoughtworks.rldd.service.contracts.base

import com.thoughtworks.rldd.service.contracts.AbstractMvcTest
import com.thoughtworks.rldd.service.member.MemberApplicationService
import com.thoughtworks.rldd.service.member.model.Member
import org.springframework.beans.factory.annotation.Autowired

class PointReduceBase extends AbstractMvcTest {

    @Autowired
    MemberApplicationService memberApplicationService

    def setup() {
        memberApplicationService.reducePoint(_ as String) >> new Member('001', 'yusong.deng', 2)
    }
}
