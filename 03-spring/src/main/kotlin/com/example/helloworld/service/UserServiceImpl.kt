package com.example.helloworld.service

import com.example.helloworld.dto.UserRegistrationDto
import com.example.helloworld.model.Role
import com.example.helloworld.model.User
import com.example.helloworld.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.function.Function
import java.util.stream.Collectors


@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    @Autowired
    private val passwordEncoder: BCryptPasswordEncoder? = null

    override fun save(registrationDto: UserRegistrationDto?): User? {
        val user = User(
            registrationDto!!.login,
            passwordEncoder!!.encode(registrationDto.password),
            listOf(Role("ROLE_USER"))
        )
        return userRepository.save(user)
    }

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(login: String): UserDetails {
        val user = userRepository.findByLogin(login)
            ?: throw UsernameNotFoundException("Invalid login or password.")
        return org.springframework.security.core.userdetails.User(
            user.login, user.password,
            mapRolesToAuthorities(user.roles!!)
        )
    }

    private fun mapRolesToAuthorities(roles: Collection<Role>): Collection<GrantedAuthority?> {
        return roles.stream().map(Function<Role, SimpleGrantedAuthority?> { role: Role ->
            SimpleGrantedAuthority(
                role.name
            )
        }).collect(Collectors.toList())
    }

    override val all: List<User?>?
        get() = userRepository.findAll()

}