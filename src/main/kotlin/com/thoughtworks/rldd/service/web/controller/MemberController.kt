package com.thoughtworks.rldd.service.web.controller

import com.thoughtworks.rldd.service.member.MemberApplicationService
import com.thoughtworks.rldd.service.member.command.AddUserCommand
import com.thoughtworks.rldd.service.member.model.User
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("members")
class MemberController(private val memberApplicationService: MemberApplicationService) {

  @PostMapping
  fun addUser(@RequestBody command: AddUserCommand): User {
    return memberApplicationService.addUser(command)
  }

  @GetMapping
  fun retrieveAllMembers(): List<User> {
    return memberApplicationService.retrieveAll()
  }

  @PostMapping("{userId}/reducePoint")
  fun reducePoint(@PathVariable("userId") userId: String): User {
    return memberApplicationService.reducePoint(userId)
  }

  @PostMapping("{userId}/restorePoint")
  fun restorePoint(@PathVariable("userId") userId: String): User {
    return memberApplicationService.restorePoint(userId)
  }

  @DeleteMapping("{userId}")
  fun removeMember(@PathVariable userId: String): User {
    return memberApplicationService.removeBy(userId)
  }

}