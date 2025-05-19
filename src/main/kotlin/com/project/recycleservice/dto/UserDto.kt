package com.project.recycleservice.dto

import com.project.recycleservice.domain.entity.User

data class UserDto(
    val id: Long,
    val email: String,
    val nickname: String
)

fun User.toDto(): UserDto = UserDto(
    id = this.userId,
    email = this.email,
    nickname = this.nickname
)