package com.naomi.demo.repository;

import com.naomi.demo.domain.Post;
import com.naomi.demo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
