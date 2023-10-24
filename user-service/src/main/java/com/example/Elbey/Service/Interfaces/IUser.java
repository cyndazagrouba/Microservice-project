package com.example.Elbey.Service.Interfaces;


import com.example.Elbey.DAO.Entities.User;





import java.util.List;

public interface IUser {
    User add(User a);
    User edit(User a);
    List<User> selectAll();
    User SelectById(int id);
    String deleteById(int id);
    User getUserByEmail(String email);
    User getUserById(int id);
    //List<User> searchUser(String query);
}

