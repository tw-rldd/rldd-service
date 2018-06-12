package com.thoughtworks.rldd.service.member.model

import spock.lang.Specification
import spock.lang.Unroll

class MemberTest extends Specification {

    @Unroll
    def "it should restore point to 3"(Member user, int expectPoint) {
        expect:
        user.restorePoint()
        assert user.point == expectPoint

        where:
        user                        | expectPoint
        new Member('id', 'name', 1) | 3
        new Member('id', 'name', 2) | 3
        new Member('id', 'name', 3) | 3
    }

    @Unroll
    def "it should reduce point"(Member user, int expectPoint) {
        expect:
        user.reducePoint()
        assert user.point == expectPoint

        where:
        user                        | expectPoint
        new Member('id', 'name', 3) | 2
        new Member('id', 'name', 2) | 1
        new Member('id', 'name', 1) | 0
        new Member('id', 'name', 0) | 0
    }

}
