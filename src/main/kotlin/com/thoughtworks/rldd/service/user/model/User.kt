package com.thoughtworks.rldd.service.user.model

class User {
  lateinit var id: String
  lateinit var name: String
  lateinit var avatar: String

  constructor(id: String, name: String, avatar: String) {
    this.id = id
    this.name = name
    this.avatar = avatar
  }

  constructor()
}