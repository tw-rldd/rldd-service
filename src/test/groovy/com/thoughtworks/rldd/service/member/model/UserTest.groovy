package com.thoughtworks.rldd.service.member.model

import spock.lang.Specification
import spock.lang.Unroll

class UserTest extends Specification {

    @Unroll
    def "it should restore point to 3"(User user, int expectPoint) {
        expect:
        user.restorePoint()
        assert user.point == expectPoint

        where:
        user                      | expectPoint
        new User('id', 'name', 1) | 3
        new User('id', 'name', 2) | 3
        new User('id', 'name', 3) | 3
    }

    @Unroll
    def "it should reduce point"(User user, int expectPoint) {
        expect:
        user.reducePoint()
        assert user.point == expectPoint

        where:
        user                      | expectPoint
        new User('id', 'name', 3) | 2
        new User('id', 'name', 2) | 1
        new User('id', 'name', 1) | 0
        new User('id', 'name', 0) | 0
    }

}
