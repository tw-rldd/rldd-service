package com.thoughtworks.rldd.service.web.controller

import com.thoughtworks.rldd.service.user.UserApplicationService
import com.thoughtworks.rldd.service.web.assembler.UserResourceAssembler
import com.thoughtworks.rldd.service.web.representation.UserResource
import org.springframework.data.domain.PageRequest
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.PagedResources
import org.springframework.hateoas.Resource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["api/users"], produces = ["application/json"])
class UserController(val userApplicationService: UserApplicationService,
                     val userResourceAssembler: UserResourceAssembler) {

  @GetMapping
  fun getUsers(@RequestParam("size") size: Int,
               @RequestParam("page") page: Int,
               @RequestParam("nameLike", required = false) nameLike: String?,
               pagedResourcesAssembler: PagedResourcesAssembler<UserResource>):
      PagedResources<Resource<UserResource>> {
    val pageRequest = PageRequest.of(page, size)
    val retrievedUsers = userApplicationService.findUsers(pageRequest)
    return pagedResourcesAssembler.toResource(retrievedUsers.map { userResourceAssembler.toResource(it) })
  }
}
