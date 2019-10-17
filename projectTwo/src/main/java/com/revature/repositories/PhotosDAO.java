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

import com.revature.beans.Activity;
import com.revature.beans.Photos;

@Repository
public class PhotosDAO {

	@Autowired
	private SessionFactory sf;
	
	/*
	 * photo Stories:
	 * A photo can login
	 * A photo can logout
	 */
	
	@Transactional
	public Photos getOnePhoto(long id) {
		Session s = sf.getCurrentSession();
		Photos a = (Photos) s.get(Photos.class, id);
		
		return a;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Photos> getAllPhotosFromOneUser(String username) {
		Session s = sf.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Photos> Photos = s.createCriteria(Photos.class)
			.add(Restrictions.eq("username", username)).list();
		
		return Photos;
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addNewphoto(Photos photo) {
		
		Activity n3w = new Activity();
		
		Session s = sf.getCurrentSession();
		try {
			s.save(photo);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	
	
}
