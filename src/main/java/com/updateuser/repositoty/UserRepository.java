package com.updateuser.repositoty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.updateuser.entity.User;

@Repository
public class UserRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void saveUser(User user) {
		hibernateTemplate.save(user);
	}

	public User getUserById(int userId) {
		return hibernateTemplate.get(User.class, userId);
	}

	@Transactional
	public void updateUser(User getUser) {
		hibernateTemplate.update(getUser);
	}

}
