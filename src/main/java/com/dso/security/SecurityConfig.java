package com.dso.security;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@Log
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private WideUserService wideUserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("Security Config!!!!");
        http.authorizeRequests()
                .anyRequest()
                .authenticated();

//        http.authorizeRequests().antMatchers("/index").hasAnyRole("MA");
        http.authorizeRequests().antMatchers("/admin/**").hasRole("MA");
        http.authorizeRequests().antMatchers("/manager/**").hasAnyRole("");
        http.formLogin().loginPage("/login").successHandler(loginSuccessHandler()).permitAll();
        http.exceptionHandling().accessDeniedPage("accessDenied");
//        http.logout().logoutSuccessHandler().invalidateHttpSession(true);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        log.info("enter method configureGlobal");
        auth.userDetailsService(wideUserService).passwordEncoder(passwordEncoder());
    }
}
