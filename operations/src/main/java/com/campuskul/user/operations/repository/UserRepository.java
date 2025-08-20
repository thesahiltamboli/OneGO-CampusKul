package com.campuskul.user.operations.repository;

import com.campuskul.user.operations.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
