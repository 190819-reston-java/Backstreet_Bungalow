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
	
	
	/*
	 * A user can login
A user can logout
A user can register
A user can update their account information
A user can upload photos
A user can view a list of recently uploaded photos
A user can view basic bio on each band member
A user can upload blog posts
A user can view a list of recently uploaded blog posts
A user can view all photos from another user
A user can view all blog posts from another user
A user can view their profile
A user can view another's user profile
A user can see their their local 'Backstreet Bungalow'
(Optional) A user can view all photos uploaded by all users
(Optional) A user can view a list of the most popular posts
(Optional) A user can comment on photos
(Optional) A user can comment on blog posts
(Optional) A user can view a feed of twitter posts that include 'backstreet boys'
(Optional) A user can upload a photo with a blog post
	 */
	
	@Autowired
	private SessionFactory sf;
	
	/*
	 * User Stories:
	 * A user can login
	 * A user can logout
	 */
	
	@Transactional
	public boolean login(String username, String password, HttpServletRequest request) {
		Session s = sf.getCurrentSession();
		if (s.createCriteria(Users.class).add(Restrictions.eq("username", username))
			.add(Restrictions.eq("password", password)) == null) {
			return false;
		}
		else {
			Users u = (Users) s.createCriteria(Users.class).add(Restrictions.eq("username", username))
					.add(Restrictions.eq("password", password));
			long id = u.getId();
			request.getSession().setAttribute("id", id);
			return true;
		}
	}
	
	@Transactional
	public Users getOneUser(long id) {
		Session s = sf.getCurrentSession();
		Users a = (Users) s.get(Users.class, id);
		
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
		Users u = (Users) s.get(Users.class, user.getId());
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
		if (user.isShowInfo())
			u.setShowInfo(user.isShowInfo());
		try {
			s.persist(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Transactional
	public boolean addNewUser(Users user) {
		
		Session s = sf.getCurrentSession();
		try {
			s.save(user);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

}
