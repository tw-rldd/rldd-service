package com.thoughtworks.rldd.service.member

import com.thoughtworks.rldd.service.member.command.AddUserCommand
import com.thoughtworks.rldd.service.member.model.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberApplicationService(val memberRepository: MemberRepository) {

  fun addUser(command: AddUserCommand) : User {
    return User("004", "jinhu.peng", 3)
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

}