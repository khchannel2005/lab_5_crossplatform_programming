package com.example.gym.controller

import com.example.gym.model.Member
import com.example.gym.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/members")
class MemberController(private val service: MemberService) {

    @GetMapping
    fun getAll(
        @RequestParam(required = false) type: String?,
        @RequestHeader("X-Client-Name", required = false) client: String?
    ): ResponseEntity<List<Member>> {
        return ResponseEntity.ok(service.getAllMembers(type))
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Member> {
        val member = service.getMember(id)
        return if (member != null) ResponseEntity.ok(member) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun create(@RequestBody member: Member): ResponseEntity<Member> {
        val created = service.addMember(member)
        return ResponseEntity.status(201).body(created)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody member: Member): ResponseEntity<Member> {
        val updated = service.updateMember(id, member)
        return if (updated != null) ResponseEntity.ok(updated) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (service.deleteMember(id)) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }
}
