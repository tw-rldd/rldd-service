package com.thoughtworks.rldd.service.member.model

class User(var id: String, var name: String, var point: Int) {
  fun reducePoint() {
    --point
    if (point == 0) {
      restorePoint()
    }
  }

  fun restorePoint() {
    point = 3
  }
}