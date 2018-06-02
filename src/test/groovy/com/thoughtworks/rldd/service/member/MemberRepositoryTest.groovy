package com.thoughtworks.rldd.service.member

import com.thoughtworks.rldd.service.AbstractRepositoryTest
import com.thoughtworks.rldd.service.member.model.User
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

class MemberRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private MemberRepository memberRepository

    @Test
    void "it should retrieve all members"() {
        def before = memberRepository.retrieveAll()

        [
                new User('001', 'yusong.deng', 3),
                new User('002', 'yugang.zhou', 2),
                new User('003', 'yuexiang.gao', 3),
        ].each { memberRepository.save(it) }

        def after = memberRepository.retrieveAll()

        assert after.size() == before.size() + 3
    }
}
