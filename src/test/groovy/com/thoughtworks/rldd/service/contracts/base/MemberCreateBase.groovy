package com.thoughtworks.rldd.service.contracts.base

import com.thoughtworks.rldd.service.contracts.AbstractMvcTest
import com.thoughtworks.rldd.service.member.MemberApplicationService
import com.thoughtworks.rldd.service.member.command.AddUserCommand
import com.thoughtworks.rldd.service.member.model.Member
import org.springframework.beans.factory.annotation.Autowired

class MemberCreateBase extends AbstractMvcTest{

    @Autowired
    MemberApplicationService memberApplicationService

    def setup() {
        memberApplicationService.addUser(new AddUserCommand('jinhu.peng')) >> new Member('004', 'jinhu.peng', 3)
    }
}
