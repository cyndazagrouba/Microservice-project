package com.example.Elbey.Service.Classe;

import com.example.Elbey.DAO.Entities.Role;
import com.example.Elbey.DAO.Entities.User;
import com.example.Elbey.DAO.Repositories.RoleRepository;
import com.example.Elbey.DAO.Repositories.UserRepository;
import com.example.Elbey.Service.Interfaces.IUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class UserService implements IUser {
    private final PasswordEncoder passwordEncoder;
   @Autowired
    private UserRepository userRepository;
   private RoleRepository roleRepository;
    @Override
    public User add(User a) {

       return  userRepository.save(a);
    }

    @Override
    public User edit(User a) {
        return userRepository.save(a);
    }

    @Override
    public List<User> selectAll() {
        return userRepository.findAll();
    }

    @Override
    public User SelectById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
     public String deleteById(int id) {
      userRepository.deleteById(id);
        return null;

    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }
    public User findByUsername(String username) {
        return userRepository.findByFirstName(username);
    }



}
