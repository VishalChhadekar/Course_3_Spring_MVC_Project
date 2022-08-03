package com.updateuser.service;

import java.util.Objects;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.updateuser.entity.User;
import com.updateuser.repositoty.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	public void saveUser(User user) {
		userRepository.saveUser(user);
	}

	public User getUserById(int userId) {
		return userRepository.getUserById(userId);

	}

	public void updateUser(User user) {
		// get userById
		if (user.getId() == null) {
			throw new NullPointerException("User Id is required");
		}
		User getUser = userRepository.getUserById(user.getId());

		// If user object is not empty or data is not same: then only update it,
		// otherwise skip
		if (Objects.nonNull(user.getUserName()) && !"".equalsIgnoreCase(user.getUserName())) {
			getUser.setUserName(user.getUserName());
		}
		if (Objects.nonNull(user.getUserEmail()) && !"".equalsIgnoreCase(user.getUserEmail())) {
			getUser.setUserEmail(user.getUserEmail());
		}
		if (Objects.nonNull(user.getUserAddress()) && !"".equalsIgnoreCase(user.getUserAddress())) {
			getUser.setUserAddress(user.getUserAddress());
		}
		if (Objects.nonNull(user.getUserPhone()) && !"".equals(String.valueOf(user.getUserPhone()))) {
			getUser.setUserPhone(user.getUserPhone());
		}
		// save updated user
		userRepository.updateUser(getUser);

	}

}
