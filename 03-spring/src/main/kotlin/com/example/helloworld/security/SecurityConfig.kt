package com.example.helloworld.security

import com.example.helloworld.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
@EnableWebSecurity
class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    @Autowired
    private val userService: UserService? = null

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationProvider(): DaoAuthenticationProvider {
        val auth = DaoAuthenticationProvider()
        auth.setUserDetailsService(userService)
        auth.setPasswordEncoder(passwordEncoder())
        return auth
    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(authenticationProvider())
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
//        http.authorizeRequests()
//            .antMatchers("/**").permitAll()
//            .anyRequest()
//            .authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
//            .invalidateHttpSession(true).clearAuthentication(true)
//            .logoutRequestMatcher(AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
//            .permitAll()

        http.httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers("/adam6024/DAC/set").authenticated()
            .antMatchers("/adam6024/DO/set").authenticated()
            .antMatchers("/**").permitAll()
            .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and()
            .logout().invalidateHttpSession(true).clearAuthentication(true).logoutRequestMatcher(AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
            .and()
            .csrf().disable()
            .formLogin().disable()
    }
}