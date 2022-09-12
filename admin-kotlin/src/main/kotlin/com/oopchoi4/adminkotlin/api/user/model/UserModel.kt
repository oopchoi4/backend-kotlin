package com.oopchoi4.adminkotlin.api.user.model

import com.oopchoi4.adminkotlin.api.user.domain.entity.Role

data class SignUpRequest(
    val username:String,
    val password:String,
    val email:String
)