package com.sei.capstone.repository;

import com.sei.capstone.model.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineRepository extends JpaRepository<Wine, Long> {
}
