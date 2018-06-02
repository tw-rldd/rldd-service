package com.thoughtworks.rldd.service.member

import com.thoughtworks.rldd.service.member.model.User
import com.thoughtworks.rldd.service.member.model.emptyUser
import org.springframework.stereotype.Service

@Service
class MemberApplicationService(val memberRepository: MemberRepository) {

  fun retrieveAll(): List<User> {
    return memberRepository.retrieveAll()
  }

  fun reducePoint(userId: String): User {
    return emptyUser()
  }

  fun restorePoint(userId: String): User {
    return emptyUser()
  }

}