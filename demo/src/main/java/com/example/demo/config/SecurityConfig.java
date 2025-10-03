package com.example.demo.config;

import com.example.demo.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // ใช้วิธีเข้ารหัสแบบ BCrypt ซึ่งเป็นมาตรฐานและปลอดภัย
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        // อนุญาตให้ทุกคนเข้าถึงหน้าแรก, CSS, JS ได้
                        .requestMatchers("/", "/css/**", "/js/**").permitAll()
                        // URL อื่นๆ ทั้งหมดต้องผ่านการยืนยันตัวตน
                        .anyRequest().authenticated()
                )
                // เปิดใช้งานการล็อกอินผ่านฟอร์ม
                // และระบุให้ใช้หน้า /login ที่เราสร้างเองใน AuthController
                .formLogin(form -> form
                        .loginPage("/login") // บอกให้ใช้หน้านี้
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());
        return http.build();
    }
}