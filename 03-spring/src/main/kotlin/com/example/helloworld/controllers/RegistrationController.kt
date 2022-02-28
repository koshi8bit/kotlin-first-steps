package com.example.helloworld.controllers

import com.example.helloworld.ResponseCreator
import org.springframework.web.bind.annotation.RequestMapping
import com.example.helloworld.service.UserService
import org.springframework.web.bind.annotation.ModelAttribute
import com.example.helloworld.dto.UserRegistrationDto
import org.json.simple.JSONObject
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller

@RequestMapping("/registration")
class RegistrationController(private val userService: UserService) {

    val responseCreator = ResponseCreator()

    @ModelAttribute("user")
    fun userRegistrationDto(): UserRegistrationDto {
        return UserRegistrationDto()
    }


    @PostMapping
    fun registerUserAccount(@ModelAttribute("user") registrationDto: UserRegistrationDto?): ResponseEntity<Any> {
        userService.save(registrationDto)
        return responseCreator.ok("Новый пользователь успешно зарегестрирован")
    }
}