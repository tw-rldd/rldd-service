package com.thoughtworks.rldd.service.web.representation

import com.fasterxml.jackson.annotation.JsonProperty
import com.thoughtworks.rldd.service.user.model.User
import org.springframework.hateoas.ResourceSupport
import org.springframework.hateoas.core.Relation

@Relation(value = "user", collectionRelation = "users")
class UserResource(user: User) : ResourceSupport() {

  @JsonProperty("id")
  var identity: String = ""
  var username: String = ""
  var avatar: String = ""

  init {
    this.identity = user.id
    this.username = user.name
    this.avatar = user.avatar
  }

}