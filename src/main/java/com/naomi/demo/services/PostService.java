//package com.naomi.demo.services;
//
//import com.naomi.demo.domain.Post;
//import com.naomi.demo.dto.PostDTO;
//import com.naomi.demo.repository.PostRepository;
//import com.naomi.demo.services.exceptions.ObjectNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class PostService {
//
//    @Autowired
//    private PostRepository userRepository;
//
//    public List<Post> findAll() {
//        return userRepository.findAll();
//    }
//
//    public Post findById(String id) {
//        Post user = userRepository.findById(id).orElse(null);
//        if (user == null) {
//            throw new ObjectNotFoundException("Post not found.");
//        }
//        return user;
//    }
//
//    public Post insert(Post user) {
//        return userRepository.insert(user);
//    }
//
//    public void delete(String id) {
//        findById(id);
//        userRepository.deleteById(id);
//    }
//
//    public Post fromDTO(PostDTO userDto) {
//        return new Post(userDto.getId(), userDto.getName(), userDto.getEmail());
//    }
//
//    public Post update(Post user) {
//        Post newPost = userRepository.findById(user.getId()).orElse(null);
//        if (newPost == null) {
//            throw new ObjectNotFoundException("Post not found.");
//        }
//        updateData(newPost, user);
//        return userRepository.save(newPost);
//    }
//
//    private void updateData(Post newPost, Post user) {
//        newPost.setEmail(user.getEmail());
//        newPost.setName(user.getName());
//    }
//}
