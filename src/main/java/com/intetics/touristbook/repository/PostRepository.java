package com.intetics.touristbook.repository;

import com.intetics.touristbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findById(int id);
}
