package com.thoughtworks.rldd.service.member

import com.thoughtworks.rldd.service.member.command.AddUserCommand
import com.thoughtworks.rldd.service.member.model.Member
import com.thoughtworks.rldd.service.member.service.UserCreator
import spock.lang.Specification

class MemberApplicationServiceTest extends Specification {

    def memberRepository = Mock(MemberRepository)
    def userCreator = Mock(UserCreator)
    def subject = new MemberApplicationService(memberRepository, userCreator)

    def "it should retrieve all members"() {
        given:
        def expectMembers = [new Member('001', 'yusong.deng', 3), new Member('002', 'yugang.zhou', 2)]
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
        userCreator.createNewUser(_ as String) >> new Member('id', username)

        when:
        def user = subject.addUser(command)

        then:
        assert user.name == username
    }

    def "it should remove member"() {
        given:
        def userId = '001'
        def member = new Member(userId, 'yusong.deng', 3)
        memberRepository.findBy(userId) >> member

        when:
        def removedMember = subject.removeBy(userId)

        then:
        assert removedMember == member
        with(memberRepository) {
            1 * removeBy(userId)
        }
    }

    def "it should reduce point"() {
        given:
        def userId = '001'
        memberRepository.findBy(userId) >> new Member(userId, 'yusong.deng')

        when:
        def reducedMember = subject.reducePoint(userId)

        then:
        assert reducedMember.point == 2
        with(memberRepository) {
            1 * save(_ as Member)
        }
    }

    def "it should restore point"() {
        given:
        def userId = '001'
        memberRepository.findBy(userId) >> new Member(userId, 'yusong.deng', 1)

        when:
        def resotredMember = subject.restorePoint(userId)

        then:
        assert resotredMember.point == 3
        with(memberRepository) {
            1 * save(_ as Member)
        }
    }
}
