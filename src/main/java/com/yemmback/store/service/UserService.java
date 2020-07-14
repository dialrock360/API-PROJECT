package com.yemmback.store.service;

import com.yemmback.store.model.*;
import com.yemmback.store.payload.reponse.UserResponse;
import com.yemmback.store.repository.UserRepository;
import com.yemmback.store.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public Hashtable getAllUsers() {

        // Retrieve Users
        List<User> users = userRepository.findAll() ;
        List<UserResponse> urp = new ArrayList<UserResponse>();
        for (User user : users) {
            UserResponse ur = new UserResponse(user.getId(),user.getUsername(), user.getEmail(), user.getFlaguser(), user.getRole(),user.getCreatedAt());
            urp.add(ur);
        }

        Hashtable cl = new Hashtable();
        cl.put("usercount", users.size());
        cl.put("users", urp);

        return cl;
    }

}
