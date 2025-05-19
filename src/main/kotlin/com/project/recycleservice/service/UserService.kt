package com.project.recycleservice.service

import com.project.recycleservice.domain.repository.UserRepository
import com.project.recycleservice.dto.UserDto
import com.project.recycleservice.dto.toDto
import org.springframework.stereotype.Service

@Service
class UserService (
    private val userRepository: UserRepository
){
    // 모든 사용자 정보 조회
    fun getAllUsers(): List<UserDto> {
        return userRepository.findAll().map { it.toDto() }
    }
}