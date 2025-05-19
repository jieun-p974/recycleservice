package com.project.recycleservice.domain.repository

import com.project.recycleservice.domain.entity.RecycleLocation
import com.project.recycleservice.domain.entity.RecycleLocationItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RecycleLocationItemRepository: JpaRepository<RecycleLocationItem, Long> {
    // 1. 객체 자체로 조회
    fun findByLocation(location: RecycleLocation): List<RecycleLocationItem>

    // 2. ID로 조회하려면 경로를 정확히!
    fun findByLocation_LocationId(locationId: Long): List<RecycleLocationItem>
}