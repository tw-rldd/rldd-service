package com.thoughtworks.rldd.service.member

import com.thoughtworks.rldd.service.member.model.User
import spock.lang.Specification

class MemberApplicationServiceTest extends Specification {

    def memberRepository = Mock(MemberRepository)
    def subject = new MemberApplicationService(memberRepository)

    def "it should retrieve all members"() {
        given:
        def expectMembers = [new User('001', 'yusong.deng', 3), new User('002','yugang.zhou', 2)]
        memberRepository.retrieveAll() >> expectMembers

        when:
        def members = subject.retrieveAll()

        then:
        assert members == expectMembers
    }
}
