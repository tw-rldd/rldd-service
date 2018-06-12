package com.thoughtworks.rldd.service.member

import com.thoughtworks.rldd.service.member.command.AddUserCommand
import com.thoughtworks.rldd.service.member.model.User
import com.thoughtworks.rldd.service.member.service.UserCreator
import spock.lang.Specification

class MemberApplicationServiceTest extends Specification {

    def memberRepository = Mock(MemberRepository)
    def userCreator = Mock(UserCreator)
    def subject = new MemberApplicationService(memberRepository, userCreator)

    def "it should retrieve all members"() {
        given:
        def expectMembers = [new User('001', 'yusong.deng', 3), new User('002','yugang.zhou', 2)]
        memberRepository.retrieveAll() >> expectMembers

        when:
        def members = subject.retrieveAll()

        then:
        assert members == expectMembers
    }

    def "it should add member"() {
        given:
        def username = "username"
        def command = new AddUserCommand(username)
        userCreator.createNewUser(_ as String) >> new User('id', username)

        when:
        def user = subject.addUser(command)

        then:
        assert user.name == username
    }
}
