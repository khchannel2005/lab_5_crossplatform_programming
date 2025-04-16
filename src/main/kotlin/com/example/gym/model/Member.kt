package com.example.gym.model

import jakarta.persistence.*

@Entity
data class Member(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String = "",

    val email: String = "",

    val membershipType: String = ""
)
