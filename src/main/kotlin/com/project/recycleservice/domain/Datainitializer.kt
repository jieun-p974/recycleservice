package com.project.recycleservice.domain

import com.project.recycleservice.domain.entity.*
import com.project.recycleservice.domain.repository.UserRepository
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDateTime


@Component
@Profile(value = ["default"])
class Datainitializer (
    private val userRepository:UserRepository,
    private val recycleLocation: RecycleLocation,
    private val supportedItem: SupportedItem,
    private val recycleLocationItem: RecycleLocationItem,
    private val favoriteLocation: FavoriteLocation,
    private val review: Review
){
    @PostConstruct
    fun initializeData(){
        // User 초기화
        val users = mutableListOf<User>(
            User(
                userId = "abc554",
                email = "",
                password = "",
                nickname = "",
                createdDte = LocalDateTime.of(2025,5,1,12,5),
                updateDte = null
            ),User(
                userId = "abx853",
                email = "",
                password = "",
                nickname = "",
                createdDte = LocalDateTime.of(2025,3,1,12,5),
                updateDte = LocalDateTime.of(2025,4,22,12,5)
            ),
        )
        userRepository.saveAll(users)
        // RecycleLocation 초기화
        // SupportedItem 초기화
        // RecycleLocationItem 초기화
        // FavoriteLocation 초기화
        // Review 초기화
    }
}