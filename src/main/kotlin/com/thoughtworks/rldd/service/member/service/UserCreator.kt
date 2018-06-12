package com.thoughtworks.rldd.service.member.service

import com.thoughtworks.rldd.service.member.model.Member
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserCreator {

  fun createNewUser(username: String): Member {
    return Member(UUID.randomUUID().toString(), username)
  }

}