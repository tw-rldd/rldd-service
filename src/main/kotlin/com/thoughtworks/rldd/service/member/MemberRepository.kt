package com.thoughtworks.rldd.service.member

import com.thoughtworks.rldd.service.member.model.User
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class MemberRepository(val namedParameterJdbcTemplate: NamedParameterJdbcTemplate) {

  fun save(user: User) {
    if (exist(user)) {
      namedParameterJdbcTemplate.update("UPDATE user SET username = :name, point = :point WHERE id = :id;",
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
    return namedParameterJdbcTemplate.queryForObject("SELECT count(*) FROM user WHERE ID = :id;",
        mapOf("id" to user.id), Int::class.java)!! > 0
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

  fun findBy(userId: String): User? {
    try {
      return namedParameterJdbcTemplate.queryForObject("SELECT * FROM user WHERE ID = :id;",
          mapOf("id" to userId),
          RowMapper { rs, _ ->
            val username = rs.getString("username")
            val point = rs.getInt("point")
            return@RowMapper User(userId, username, point)
          })
    } catch (error: EmptyResultDataAccessException) {
      return null
    }
  }

  fun removeBy(userId: String) {
    namedParameterJdbcTemplate.update("DELETE FROM user WHERE ID = :id", mapOf("id" to userId))
  }

}