package com.thoughtworks.rldd.service.member

import com.thoughtworks.rldd.service.AbstractRepositoryTest
import com.thoughtworks.rldd.service.member.model.Member
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

class MemberRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private MemberRepository subject

    @Test
    void "it should retrieve all members"() {
        def before = subject.retrieveAll()

        [
                new Member('001', 'yusong.deng', 3),
                new Member('002', 'yugang.zhou', 2),
                new Member('003', 'yuexiang.gao', 3),
        ].each { subject.save(it) }

        def after = subject.retrieveAll()

        assert after.size() == before.size() + 3
    }

    @Test
    void "it should remove member by id"() {
        def member = new Member(UUID.randomUUID().toString(), 'for remove')
        subject.save(member)
        def existUser = subject.findBy(member.id)

        assert existUser != null

        subject.removeBy(member.id)
        def notExistUser = subject.findBy(member.id)

        assert notExistUser == null
    }
}
