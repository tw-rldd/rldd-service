package com.thoughtworks.rldd.service.user

import com.thoughtworks.rldd.service.user.model.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class UserRepository {

  fun retrieve(page: Pageable) : Page<User>{
    return Page.empty(page)
  }

}