package com.example.helloworld.dto

class UserRegistrationDto {
    var login: String? = null
    var password: String? = null

    constructor() {}

    constructor(login: String?, password: String?) : super() {
        this.login = login
        this.password = password
    }
}