package com.example.helloworld.model
import jakarta.persistence.*

@Entity
@Table(name = "role")
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    var name: String? = null

    constructor() {}

    constructor(name: String?) : super() {
        this.name = name
    }
}