package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // 이메일로 사용자를 찾는 메서드를 정의합니다.
    User findByEmail(String email);
}