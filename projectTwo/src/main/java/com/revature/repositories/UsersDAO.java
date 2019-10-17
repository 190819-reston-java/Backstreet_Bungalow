package com.revature.repositories;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Users;

@Repository
public class UsersDAO {

	@Autowired
	private SessionFactory sf;

	@Transactional
	public Users login(String username, String password, HttpServletRequest request) {
		Session s = sf.getCurrentSession();
		Users u = null;

		u = (Users) s.createCriteria(Users.class).add(Restrictions.eq("username", username))
				.add(Restrictions.eq("password", password)).uniqueResult();
		if (u == null)
			return null;
		else {
			long id = u.getId();
			request.getSession().setAttribute("id", id);
			return u;
		}
	}

	@Transactional
	public Users getOneUser(String username) {
		Session s = sf.getCurrentSession();

		Users a = (Users) s.createCriteria(Users.class).add(Restrictions.eq("username", username)).uniqueResult();
		if (a == null)
			return null;
		else
			return a;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Users> getAllUsers() {
		Session s = sf.getCurrentSession();

		@SuppressWarnings("unchecked")
		List<Users> users = s.createCriteria(Users.class).list();

		return users;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updateUser(Users user) {
		Session s = sf.getCurrentSession();
		if (s.createCriteria(Users.class).add(Restrictions.eq("username", user.getUsername())).uniqueResult() != null)
			return false;
		if (s.createCriteria(Users.class).add(Restrictions.eq("email", user.getEmail())).uniqueResult() != null)
			return false;
		Users u = null;
		u = (Users) s.get(Users.class, user.getId());
		if (user.getFirstName() != null)
			u.setFirstName(user.getFirstName());
		if (user.getLastName() != null)
			u.setLastName(user.getLastName());
		if (user.getUsername() != null)
			u.setUsername(user.getUsername());
		if (user.getEmail() != null)
			u.setEmail(user.getEmail());
		if (user.getPassword() != null)
			u.setPassword(user.getPassword());
		try {
			s.persist(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addNewUser(Users user) {

		Session s = sf.getCurrentSession();
		if (user.getFirstName() == null || user.getLastName() == null || user.getUsername() == null
				|| user.getEmail() == null || user.getPassword() == null)
			return false;
		if (s.createCriteria(Users.class).add(Restrictions.eq("username", user.getUsername())).uniqueResult() != null)
			return false;
		if (s.createCriteria(Users.class).add(Restrictions.eq("email", user.getEmail())).uniqueResult() != null)
			return false;
		try {
			s.save(user);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

}
