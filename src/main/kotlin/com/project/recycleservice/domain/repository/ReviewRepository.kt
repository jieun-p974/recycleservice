package com.project.recycleservice.domain.repository

import com.project.recycleservice.domain.entity.RecycleLocation
import com.project.recycleservice.domain.entity.Review
import com.project.recycleservice.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository: JpaRepository<Review, Long> {
    fun findByLocation(location: RecycleLocation): List<Review> // 분리수거 장소별 리뷰 조회
    fun findByUser(user: User): List<Review> // 사용자별 리뷰 조회
}