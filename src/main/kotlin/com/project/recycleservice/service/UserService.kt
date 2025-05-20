package com.project.recycleservice.service

import com.project.recycleservice.domain.entity.User
import com.project.recycleservice.domain.repository.UserRepository
import com.project.recycleservice.dto.UserDto
import com.project.recycleservice.dto.UserSignupDto
import com.project.recycleservice.dto.toDto
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService (
    private val userRepository: UserRepository
){
    // 모든 사용자 정보 조회
    fun getAllUsers(): List<UserDto> {
        return userRepository.findAll().map { it.toDto() }
    }
    fun signup(dto: UserSignupDto): Long{
        // 존재하는 이메일인지 체크
        if(userRepository.findByEmail(dto.email) != null){
            throw IllegalArgumentException("이미 존재하는 이메일 입니다.")
        }
        val user = User(
            email =  dto.email,
            password = dto.password,
            nickname = dto.nickname,
            createdDte = LocalDateTime.now(),
            updateDte = null
        )
        return userRepository.save(user).userId
    }
}