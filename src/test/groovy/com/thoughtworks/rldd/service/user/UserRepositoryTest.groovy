package com.thoughtworks.rldd.service.user

import com.thoughtworks.rldd.service.AbstractRepositoryTest
import com.thoughtworks.rldd.service.user.model.User
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest

class UserRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private UserRepository subject

    @Test
    void "it should retrieve users"() {
        def pageRequest = new PageRequest(0, 10)
        def before = subject.retrieve(pageRequest)

        (1..3).collect {
            new User(it.toString(), "username${it.toString()}", "avatar${it.toString()}")
        }
        .each { subject.save(it) }

        def after = subject.retrieve(pageRequest)

        assert after.getTotalElements() == before.getTotalElements() + 3
    }
}
