package com.thoughtworks.rldd.service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RlddServiceApplication

fun main(args: Array<String>) {
  runApplication<RlddServiceApplication>(*args)
}
