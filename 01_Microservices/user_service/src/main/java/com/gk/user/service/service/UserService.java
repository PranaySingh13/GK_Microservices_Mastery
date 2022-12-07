package com.gk.user.service.service;

import java.util.List;

import com.gk.user.service.entity.User;

public interface UserService {

	User saveUser(User user);

	List<User> getAllUsers();

	User getUser(String userId);

}
