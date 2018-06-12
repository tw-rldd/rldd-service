package com.thoughtworks.rldd.service.member

import com.thoughtworks.rldd.service.member.model.Member
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class MemberRepository(val namedParameterJdbcTemplate: NamedParameterJdbcTemplate) {

  fun save(member: Member) {
    if (exist(member)) {
      namedParameterJdbcTemplate.update("UPDATE member SET username = :name, point = :point WHERE id = :id;",
          mapOf(
              "id" to member.id,
              "name" to member.name,
              "point" to member.point
          ))
    } else {
      namedParameterJdbcTemplate.update("INSERT INTO member (id, username, point) VALUES (:id, :name, :point);",
          mapOf(
              "id" to member.id,
              "name" to member.name,
              "point" to member.point
          ))
    }
  }

  private fun exist(member: Member): Boolean {
    return namedParameterJdbcTemplate.queryForObject("SELECT count(*) FROM member WHERE ID = :id;",
        mapOf("id" to member.id), Int::class.java)!! > 0
  }

  fun retrieveAll(): List<Member> {
    return namedParameterJdbcTemplate.query("SELECT * FROM member;",
        RowMapper { rs, _ ->
          val id = rs.getString("id")
          val username = rs.getString("username")
          val point = rs.getInt("point")
          return@RowMapper Member(id, username, point)
        })
  }

  fun findBy(userId: String): Member? {
    try {
      return namedParameterJdbcTemplate.queryForObject("SELECT * FROM member WHERE ID = :id;",
          mapOf("id" to userId),
          RowMapper { rs, _ ->
            val username = rs.getString("username")
            val point = rs.getInt("point")
            return@RowMapper Member(userId, username, point)
          })
    } catch (error: EmptyResultDataAccessException) {
      return null
    }
  }

  fun removeBy(userId: String) {
    namedParameterJdbcTemplate.update("DELETE FROM member WHERE ID = :id", mapOf("id" to userId))
  }

}