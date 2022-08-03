package com.updateuser.controller;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.updateuser.entity.User;
import com.updateuser.error.InvalidUserData;
import com.updateuser.error.UserNotFoundException;
import com.updateuser.service.UserServiceImp;

@Controller
@Validated
public class UserContoller {

	@Autowired
	private UserServiceImp userServiceImp;

	@RequestMapping("/adduser")
	public String hello() {
		return "getuserdata";
	}

	// add new user
	@RequestMapping(value = "/adduserdata", method = RequestMethod.POST)
	public String addNewUser(@ModelAttribute User user, BindingResult result) throws Exception {
		if (user.getUserPhone() == null) {
			throw new InvalidUserData("Invalid User Data. All fields are required");
		}
		if (result.hasErrors()) {
			throw new InvalidUserData("Invalid User Data. All fields are required");
		}
		userServiceImp.saveUser(user);
		return "success";

	}

	// get userById
	@RequestMapping(value = "/getuser")
	public String getUserById(@RequestParam("userId") Integer userId, Model model) throws Exception {

		// fetch user from database
		User user = userServiceImp.getUserById(userId);
		if (Objects.isNull(user)) {
			throw new UserNotFoundException("User Not present with this Id");
		}
		model.addAttribute(user);
		return "showUser";
	}

	@RequestMapping("/modifyuser")
	public String updateRequist() {
		return "updateuser";
	}

	// update user
	@RequestMapping(value = "/updateuserdetials", method = RequestMethod.POST)
	public String updateUserDetials(@ModelAttribute User user, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			throw new NullPointerException("Enter correct user id");
		}
		userServiceImp.updateUser(user);
		return "success";
	}

}
