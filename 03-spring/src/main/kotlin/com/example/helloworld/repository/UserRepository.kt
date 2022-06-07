package com.example.helloworld.repository

import com.example.helloworld.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User?, Long?> {
    fun findByLogin(login: String?): User?
}