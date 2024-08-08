package com.test.Restfullweb.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.user.post.Post;

public interface UserPostRepository extends JpaRepository<Post, Integer>{

}
