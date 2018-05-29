package com.thoughtworks.rldd.service

import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner)
@SpringBootTest(classes = RlddServiceApplication)
@ActiveProfiles("test")
abstract class AbstractRepositoryTest {
}
