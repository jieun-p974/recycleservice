package com.project.recycleservice.domain.repository

import com.project.recycleservice.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>{
    fun findByEmail(email: String) : User? // email 기준으로 사용자 조회, 없을 수 있으니까 ?로 nullable 설정
    fun findByEmailAndPassword(email: String, password: String): User?
}