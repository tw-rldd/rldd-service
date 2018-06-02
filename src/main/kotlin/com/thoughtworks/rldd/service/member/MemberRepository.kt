package com.thoughtworks.rldd.service.member

import com.thoughtworks.rldd.service.member.model.User
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class MemberRepository(val namedParameterJdbcTemplate: NamedParameterJdbcTemplate) {

  fun save(user: User) {
    if (exist(user)) {
      namedParameterJdbcTemplate.update("UPDATE user SET username = :name, point = :point WHERE id = :point;",
          mapOf(
              "id" to user.id,
              "name" to user.name,
              "point" to user.point
          ))
    } else {
      namedParameterJdbcTemplate.update("INSERT INTO user (id, username, point) VALUES (:id, :name, :point);",
          mapOf(
              "id" to user.id,
              "name" to user.name,
              "point" to user.point
          ))
    }
  }

  private fun exist(user: User): Boolean {
    return namedParameterJdbcTemplate.queryForObject("SELECT count(*) FROM user WHERE USERNAME = :name;",
        mapOf("name" to user.name), Int::class.java) == 1
  }

  fun retrieveAll(): List<User> {
    return namedParameterJdbcTemplate.query("SELECT * FROM user;",
        RowMapper { rs, _ ->
          val id = rs.getString("id")
          val username = rs.getString("username")
          val point = rs.getInt("point")
          return@RowMapper User(id, username, point)
        })
  }

}