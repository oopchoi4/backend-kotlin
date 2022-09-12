package com.oopchoi4.adminkotlin.api.user

import com.oopchoi4.adminkotlin.api.user.model.SignUpRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService
) {
    @PostMapping("/signup")
    fun signUp(@RequestBody request: SignUpRequest){
        userService.signUp(request)
    }
}