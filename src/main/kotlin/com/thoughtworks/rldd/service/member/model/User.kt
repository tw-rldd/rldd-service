package com.thoughtworks.rldd.service.member.model

class User {
  var id: String
  var name: String
  var point: Int

  constructor(id: String, name: String, point: Int) {
    this.id = id
    this.name = name
    this.point = point
  }

  constructor(id: String, name: String) : this(id, name, 3)

  fun reducePoint() {
    if (point > 0) {
      --point
    }
  }

  fun restorePoint() {
    point = 3
  }
}