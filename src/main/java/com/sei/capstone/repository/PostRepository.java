package com.sei.capstone.repository;

import com.sei.capstone.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByWineId(@Param("wineId") Long wineId);

}
