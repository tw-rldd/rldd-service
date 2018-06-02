package com.thoughtworks.rldd.service.member.model

class User(var id: String, var name: String, var point: Int)

fun emptyUser(): User {
  return User("", "", 0)
}