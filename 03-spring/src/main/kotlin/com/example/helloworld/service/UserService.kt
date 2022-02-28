package com.example.helloworld.service

import com.example.helloworld.model.User
import org.springframework.security.core.userdetails.UserDetailsService
import com.example.helloworld.dto.UserRegistrationDto

interface UserService : UserDetailsService {
    fun save(registrationDto: UserRegistrationDto?): User?
    val all: List<User?>?
}