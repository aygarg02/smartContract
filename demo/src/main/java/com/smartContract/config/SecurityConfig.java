package com.smartContract.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig {

    @Autowired
    private UserDetailimp userDetailService;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthen = new DaoAuthenticationProvider();
        daoAuthen.setUserDetailsService(userDetailService);
        daoAuthen.setPasswordEncoder(passwordEncoder());
        return daoAuthen;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
     
        httpSecurity.authorizeHttpRequests(authorize->{
           authorize.requestMatchers("/users/**").authenticated();
           authorize.anyRequest().permitAll();
                });
                // httpSecurity.formLogin(Customizer.withDefaults());//
                httpSecurity.formLogin(formLogin -> 
                formLogin
                    .loginPage("/signin")
                    .loginProcessingUrl("/doLogin")
                    .defaultSuccessUrl("/users/index")  // URL of your custom login page
                    .permitAll()           // Allow everyone to see the login page
            );
        return httpSecurity.build();
    }
}
