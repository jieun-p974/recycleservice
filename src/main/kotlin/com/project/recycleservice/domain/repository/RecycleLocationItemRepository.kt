package com.project.recycleservice.domain.repository

import com.project.recycleservice.domain.entity.RecycleLocationItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RecycleLocationItemRepository: JpaRepository<RecycleLocationItem, Long> {
    fun findByLocationId(locationId: Long): List<RecycleLocationItem>
    fun findByItemId(itemId: Long): List<RecycleLocationItem>
}