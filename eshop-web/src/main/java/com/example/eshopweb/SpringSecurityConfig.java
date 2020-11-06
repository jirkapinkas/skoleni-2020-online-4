package com.example.eshopweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
                .antMatchers("/actuator/**")
                .hasRole("MONITORING")
                .antMatchers("/**")
                .hasRole("USER")
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .logout()
                .and()
                .rememberMe();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.builder()
                        .username("jirka")
//                        .password("{noop}jirka") // heslo je v plaintextu
                        .password("{bcrypt}$2a$10$dvV0sDfcXtRVahLv66GT2eqfin0PlKVOHc3TmgotFx.e1aW.XBUue") // heslo je v bcrypt
                        .roles("USER", "ADMIN", "MONITORING")
                        .build();
        return new InMemoryUserDetailsManager(user);
    }


    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("jirka"));
        System.out.println(new BCryptPasswordEncoder().matches("jirka", "$2a$10$dvV0sDfcXtRVahLv66GT2eqfin0PlKVOHc3TmgotFx.e1aW.XBUue"));
    }

}