package com.oopchoi4.adminkotlin.api.user

import com.fasterxml.jackson.databind.ObjectMapper
import com.oopchoi4.adminkotlin.api.user.domain.entity.User
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.*
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@ActiveProfiles("test")
internal class UserServiceTest(
    @Autowired private val restTemplate: TestRestTemplate,
    @Autowired private val mapper: ObjectMapper
) {

    @Test
    fun signUpTest() {
        val user = User(
            username = "oopchoi2",
            password = "1234",
            email = "oopchoi4@gmail.com"
        )

        val requestEntity = HttpEntity(user)
        restTemplate.exchange("/api/v1/users/signup", HttpMethod.POST, requestEntity, String::class.java).also {
            assertEquals(HttpStatus.OK, it.statusCode)
        }
    }
}