package com.project.recycleservice.domain.repository

import com.project.recycleservice.domain.entity.SupportedItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SupportedItemRepository : JpaRepository<SupportedItem, Long> {
    fun findByNameContaining(name: String) : SupportedItem? // 분리수거 항목으로 검색
}