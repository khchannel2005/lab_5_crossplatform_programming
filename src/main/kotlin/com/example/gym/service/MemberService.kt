package com.example.gym.service

import com.example.gym.model.Member
import com.example.gym.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(private val repository: MemberRepository) {

    fun getAllMembers(type: String?): List<Member> {
        return if (type != null) repository.findByMembershipTypeIgnoreCase(type)
        else repository.findAll()
    }

    fun getMember(id: Long): Member? = repository.findById(id).orElse(null)

    fun addMember(member: Member): Member = repository.save(member)

    fun updateMember(id: Long, updated: Member): Member? {
        return if (repository.existsById(id)) {
            repository.save(updated.copy(id = id))
        } else null
    }

    fun deleteMember(id: Long): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else false
    }
}
