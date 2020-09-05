package com.naomi.demo.services;

import com.naomi.demo.domain.User;
import com.naomi.demo.dto.UserDTO;
import com.naomi.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.naomi.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ObjectNotFoundException("User not found.");
        }
        return user;
    }

    public User insert (User user) {
        return userRepository.insert(user);
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDTO(UserDTO userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }

    public User update(User user) {
        User newUser = userRepository.findById(user.getId()).orElse(null);
        if (newUser == null) {
            throw new ObjectNotFoundException("User not found.");
        }
        updateData(newUser, user);
        return userRepository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());
    }
}
