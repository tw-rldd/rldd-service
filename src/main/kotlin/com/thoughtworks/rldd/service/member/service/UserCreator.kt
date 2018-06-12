package com.thoughtworks.rldd.service.member.service

import com.thoughtworks.rldd.service.member.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserCreator {

  fun createNewUser(username: String): User {
    return User(UUID.randomUUID().toString(), username)
  }

}