package com.oopchoi4.adminkotlin.common.exception

sealed class ServerException(
    val code: Int,
    override val message: String
): RuntimeException(message)

data class UserExistsException(
    override val message:String = "이미 존재하는 사용자입니다."
): ServerException(409, message)