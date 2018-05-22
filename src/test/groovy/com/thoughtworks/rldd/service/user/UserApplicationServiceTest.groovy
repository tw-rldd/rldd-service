package com.thoughtworks.rldd.service.user

import com.thoughtworks.rldd.service.user.model.User
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import spock.lang.Specification

class UserApplicationServiceTest extends Specification {

    def userRepository = Mock(UserRepository)
    def target = new UserApplicationService(userRepository)

    def "it should retrieve users"() {
        given:
        def request = new PageRequest(0, 2)
        def expectUsers = new PageImpl([new User(), new User()], request, 3)

        userRepository.retrieve(request) >> expectUsers

        when:
        def users = target.findUsers(request)

        then:
        assert users == expectUsers
    }
}
