package com.oopchoi4.adminkotlin.api.user

import org.springframework.data.jpa.repository.JpaRepository
import com.oopchoi4.adminkotlin.api.user.domain.entity.User
import java.util.*

interface UserRepository : JpaRepository<User, Int> {
  fun findByUsername(username: String): Optional<User>
}
