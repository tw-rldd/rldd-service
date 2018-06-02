package com.thoughtworks.rldd.service.contracts.base

import com.thoughtworks.rldd.service.contracts.AbstractMvcTest
import com.thoughtworks.rldd.service.member.MemberApplicationService
import com.thoughtworks.rldd.service.member.model.User
import org.springframework.beans.factory.annotation.Autowired

import static org.mockito.ArgumentMatchers.anyString

class PointRestoreBase extends AbstractMvcTest{

    @Autowired
    MemberApplicationService memberApplicationService

    def setup() {
        memberApplicationService.restorePoint(_ as String) >> new User('002', 'yugang.zhou', 3)
    }
}
