package com.thoughtworks.rldd.service.member.command

class AddUserCommand {

  lateinit var name: String

  constructor()

  constructor(name: String) {
    this.name = name
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as AddUserCommand

    if (name != other.name) return false

    return true
  }

  override fun hashCode(): Int {
    return name.hashCode()
  }


}