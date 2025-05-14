package com.project.recycleservice.domain.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "favorite_location")
class FavoriteLocation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val favoriteId: Long = 0,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToOne
    @JoinColumn(name = "location_id")
    val location: RecycleLocation,

    val createdDate: LocalDateTime = LocalDateTime.now()
) {
}