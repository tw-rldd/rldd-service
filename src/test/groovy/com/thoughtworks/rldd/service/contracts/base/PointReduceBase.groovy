package com.thoughtworks.rldd.service.contracts.base

import com.thoughtworks.rldd.service.contracts.AbstractMvcTest
import com.thoughtworks.rldd.service.member.MemberApplicationService
import com.thoughtworks.rldd.service.member.model.User
import org.springframework.beans.factory.annotation.Autowired

import static org.mockito.ArgumentMatchers.anyString

class PointReduceBase extends AbstractMvcTest {

    @Autowired
    MemberApplicationService memberApplicationService

    def setup() {
        memberApplicationService.reducePoint(_ as String) >> new User('001', 'yusong.deng', 2)
    }
}
