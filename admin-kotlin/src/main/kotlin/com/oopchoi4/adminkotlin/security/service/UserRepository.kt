package com.oopchoi4.adminkotlin.security.service

import org.springframework.data.jpa.repository.JpaRepository
import com.oopchoi4.adminkotlin.security.domain.User
import java.util.*

interface UserRepository : JpaRepository<User, Int> {
  fun findByUsername(username: String): Optional<User>
}
