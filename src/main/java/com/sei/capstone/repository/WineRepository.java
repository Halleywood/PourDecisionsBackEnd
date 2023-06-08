package com.sei.capstone.repository;

import com.sei.capstone.model.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * built in queries from JPA, no custom methods needed.
 */
public interface WineRepository extends JpaRepository<Wine, Long> {
}
