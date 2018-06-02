package com.thoughtworks.rldd.service.member.model

class User(var id: String, var name: String, var point: Int) {
  fun reducePoint() {
    if (point > 0) {
      --point
    }
  }

  fun restorePoint() {
    point = 3
  }
}