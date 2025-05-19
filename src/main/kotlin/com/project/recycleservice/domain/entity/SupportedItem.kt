package com.project.recycleservice.domain.entity

import jakarta.persistence.*

@Entity
@Table(name = "supported_item")
class SupportedItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val itemId: Long = 0,

    @Column(nullable = false, unique = true)
    val name: String
) {
}