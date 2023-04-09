package com.jojoldu.book.springboot.web.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p From Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
