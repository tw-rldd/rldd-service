package com.thoughtworks.rldd.service.user

import com.thoughtworks.rldd.service.user.model.User
import lombok.extern.slf4j.Slf4j
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Slf4j
@Service
class UserApplicationService(private val userRepository: UserRepository) {

  val users = listOf("Yusong Deng", "Yuexiang Gao", "Yugang Zhou", "Di Zhang", "Jinghu Peng")
      .mapIndexed { id, name ->
        User(id.toString(), name, "")
      }


  fun findUsers(page: Pageable): Page<User> {
    return userRepository.retrieve(page)
  }

}