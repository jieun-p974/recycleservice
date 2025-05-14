package com.project.recycleservice.domain.repository

import com.project.recycleservice.domain.entity.RecycleLocation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RecycleLocationRepository : JpaRepository<RecycleLocation, Long> {
    fun findByCategory(category: String): List<RecycleLocation>
    fun findByAddressContaining(address: String): List<RecycleLocation>
}