package com.example.gym.repository

import com.example.gym.model.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Long> {
    fun findByMembershipTypeIgnoreCase(type: String): List<Member>
}
