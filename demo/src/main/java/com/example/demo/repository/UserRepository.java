package com.example.demo.repository;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // เปลี่ยนให้คืนค่าเป็น Optional<User> เพื่อการจัดการ null ที่ดีกว่า
    Optional<User> findByUsername(String username);
}