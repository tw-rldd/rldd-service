package com.thoughtworks.rldd.service.contracts.base

import com.thoughtworks.rldd.service.contracts.AbstractMvcTest
import com.thoughtworks.rldd.service.member.MemberApplicationService
import com.thoughtworks.rldd.service.member.model.Member
import org.springframework.beans.factory.annotation.Autowired

class PointRestoreBase extends AbstractMvcTest{

    @Autowired
    MemberApplicationService memberApplicationService

    def setup() {
        memberApplicationService.restorePoint(_ as String) >> new Member('002', 'yugang.zhou', 3)
    }
}
