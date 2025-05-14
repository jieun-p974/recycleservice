package com.project.recycleservice.domain.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "recycle_location")
class RecycleLocation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val locationId: Long = 0,

    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val provider: String?, // 관리 업체, null일 수 있음.
    val category: String, // 분리수거 카테고리
    val phoneNumber: String? = null, // 업체 연락처, null일 수 있고 기본값이 null
    val createdDte: LocalDateTime = LocalDateTime.now(),
    val updateDte: LocalDateTime  = LocalDateTime.now()
) {
}