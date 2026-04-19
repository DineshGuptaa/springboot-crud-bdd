package com.apis.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.apis.model.User;
import com.apis.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        return repository.save(user);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User update(Long id, User user) {
        User existing = getById(id);
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setAge(user.getAge());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}