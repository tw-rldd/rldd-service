package com.thoughtworks.rldd.service.contracts.base

import com.thoughtworks.rldd.service.contracts.AbstractMvcTest
import com.thoughtworks.rldd.service.user.UserApplicationService
import com.thoughtworks.rldd.service.user.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

class UserSearchBase extends AbstractMvcTest {

    @Autowired
    UserApplicationService userApplicationService

    @Override
    def setup() {
        userApplicationService.findUsers(_ as Pageable) >>
                { Pageable page ->
                    def users = ['Yusong Deng', 'Yuexiang Gao', 'Yugang Zhou', 'Di Zhang', 'Jinghu Peng'].withIndex().collect {
                        new User(User.Identify.Companion.of(it.getSecond().toString()), it.getFirst(), '')
                    }
                    new PageImpl<User>(users, page, page.getPageSize() + 1)
                }
    }
}
