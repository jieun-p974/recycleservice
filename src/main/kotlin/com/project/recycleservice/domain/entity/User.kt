package com.project.recycleservice.domain.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "users") //
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: String,

    @Column(unique = true)
    val email: String,

    @Column(nullable = false)
    val password: String,

    @Column(nullable = false)
    val nickname: String,

    val createdDte: LocalDateTime? = LocalDateTime.now(),

    val updateDte: LocalDateTime? = LocalDateTime.now()
){

}