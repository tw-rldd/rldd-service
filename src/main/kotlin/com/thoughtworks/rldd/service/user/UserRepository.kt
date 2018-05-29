package com.thoughtworks.rldd.service.user

import com.thoughtworks.rldd.service.user.model.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UserRepository(val namedTemplate: NamedParameterJdbcTemplate) {

  fun save(user: User) {
    if (has(user)) {
      namedTemplate.update("UPDATE user SET username = :username, avatar = :avatar WHERE id = :id;",
          mapOf("id" to user.id, "username" to user.name, "avatar" to user.avatar))
    } else {
      namedTemplate.update("INSERT INTO user (id, username, avatar) VALUES (:id, :username, :avatar);",
          mapOf("id" to user.id, "username" to user.name, "avatar" to user.avatar))
    }
  }

  fun has(user: User): Boolean {
    return namedTemplate.queryForObject("SELECT count(*) FROM user WHERE id = :id;", mapOf("id" to user.id),
        Integer::class.java) == Integer(1)
  }

  fun retrieve(page: Pageable): Page<User> {
    val users = namedTemplate.query("SELECT * FROM user LIMIT :size OFFSET :page",
        mapOf(Pair("size", page.pageSize), Pair("page", page.offset)),
        RowMapper { rs, _ ->
          val id = rs.getString("id")
          val username = rs.getString("username")
          val avatar = rs.getString("avatar")
          return@RowMapper User(id, username, avatar)
        })
    val count = countUsers()
    return PageImpl(users, page, count)
  }

  private fun countUsers(): Long {
    return namedTemplate.queryForObject("SELECT count(*) FROM user", emptyMap<String, String>(), Long::class.java)
        ?: 0
  }

}