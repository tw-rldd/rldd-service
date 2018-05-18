package com.thoughtworks.rldd.service.web.assembler

import com.thoughtworks.rldd.service.user.UserResource
import com.thoughtworks.rldd.service.user.model.User
import com.thoughtworks.rldd.service.web.controller.UserController
import org.springframework.hateoas.mvc.ResourceAssemblerSupport
import org.springframework.stereotype.Component

@Component
class UserResourceAssembler
  : ResourceAssemblerSupport<User, UserResource>(UserController::class.java, UserResource::class.java) {


  override fun toResource(user: User): UserResource {
    return UserResource(user)
  }


}