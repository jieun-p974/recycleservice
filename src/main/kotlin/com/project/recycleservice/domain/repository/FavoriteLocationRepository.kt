package com.project.recycleservice.domain.repository

import com.project.recycleservice.domain.entity.FavoriteLocation
import com.project.recycleservice.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FavoriteLocationRepository: JpaRepository<FavoriteLocation, Long> {
    fun findByUser(user: User): List<FavoriteLocation>
}