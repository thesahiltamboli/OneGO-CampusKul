package com.campuskul.user.operations.repository;

import com.campuskul.user.operations.model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {
}
