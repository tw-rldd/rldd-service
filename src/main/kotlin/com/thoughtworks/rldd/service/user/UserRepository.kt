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

  fun retrieve(page: Pageable): Page<User> {
    val users = namedTemplate.query("SELECT * FROM user LIMIT :size OFFSET :page",
        mapOf(Pair("size", page.pageSize), Pair("page", page.offset)),
        RowMapper { rs, _ ->
          val id = rs.getString("id")
          val username = rs.getString("name")
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