package com.oopchoi4.adminkotlin.api.user

import com.oopchoi4.adminkotlin.api.user.domain.entity.User
import com.oopchoi4.adminkotlin.api.user.model.SignUpRequest
import com.oopchoi4.adminkotlin.common.exception.UserExistsException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder
) {
    fun signUp(signUpRequest: SignUpRequest) {
        with(signUpRequest) {
            val user = userRepository.findByUsername(username)
            if (user.isPresent()) {
                throw UserExistsException()
            }
        }
        val user = User(
            username = signUpRequest.username,
            password = bCryptPasswordEncoder.encode(signUpRequest.password),
            email = signUpRequest.email
        )
        userRepository.save(user)
    }
}