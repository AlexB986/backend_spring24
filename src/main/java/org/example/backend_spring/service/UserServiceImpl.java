package org.example.backend_spring.service;

import org.example.backend_spring.model.User;
import org.example.backend_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        User userFind = findUserById(user.getId());
        if (userFind != null) {
            userRepository.save(user);
        }
    }

    @Transactional
    @Override
    public User findUserById(Long id) {
        Optional<User> userFindById = userRepository.findById(id);
        if (userFindById.isPresent()) {
            return userFindById.get();
        }
        return null;
    }

    @Transactional
    @Override
    public List<User> findAllUsers() {
        List<User> userList = (List<User>) userRepository.findAll();
        return userList;
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
