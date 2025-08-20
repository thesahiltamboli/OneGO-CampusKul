package com.campuskul.user.operations.repository;

import com.campuskul.user.operations.model.Alumni;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumniRepository extends JpaRepository<Alumni, Long> {
}
