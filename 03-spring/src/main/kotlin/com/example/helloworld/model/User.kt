package com.example.helloworld.model

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "users", uniqueConstraints = [UniqueConstraint(columnNames = ["login"])])
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    var login: String? = null
    var password: String? = null

    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "users_roles",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")]
    )

    var roles: Collection<Role>? = null

    constructor() {}

    constructor(login: String?, password: String?, roles: Collection<Role>?) : super() {
        this.login = login
        this.password = password
        this.roles = roles
    }
}