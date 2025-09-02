package com.learn.rest.webservices.restful_web_services.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUserId(int id);
    Post findPostById(int id);
}
