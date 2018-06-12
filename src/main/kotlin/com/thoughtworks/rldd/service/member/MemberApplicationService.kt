package com.thoughtworks.rldd.service.member

import com.thoughtworks.rldd.service.member.command.AddUserCommand
import com.thoughtworks.rldd.service.member.model.User
import com.thoughtworks.rldd.service.member.service.UserCreator
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberApplicationService(val memberRepository: MemberRepository,
                               val userCreator: UserCreator) {

  fun addUser(command: AddUserCommand) : User {
    val newUser = userCreator.createNewUser(command.name)
    memberRepository.save(newUser)
    return newUser
  }

  fun retrieveAll(): List<User> {
    return memberRepository.retrieveAll()
  }

  fun reducePoint(userId: String): User {
    val user = memberRepository.findBy(userId) ?: throw RuntimeException("error")
    user.reducePoint()
    memberRepository.save(user)
    return user
  }

  fun restorePoint(userId: String): User {
    val user = memberRepository.findBy(userId) ?: throw RuntimeException("error")
    user.restorePoint()
    memberRepository.save(user)
    return user
  }

  fun removeBy(userId: String): User {
    return User("id", "name")
  }

}