package com.project.recycleservice.domain.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "review")
class Review (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val reviewId: Long = 0,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToOne
    @JoinColumn(name = "location_id")
    val location: RecycleLocation,

    val rating: Int, // 점수
    val content: String, // 리뷰 내용
    val createdDte: LocalDateTime = LocalDateTime.now(),
    val updateDte : LocalDateTime = LocalDateTime.now()
){
}