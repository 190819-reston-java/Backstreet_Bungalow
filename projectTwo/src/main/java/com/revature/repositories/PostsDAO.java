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

import com.revature.beans.Photos;
import com.revature.beans.Posts;

@Repository
public class PostsDAO {
	
	@Autowired
	private SessionFactory sf;
	
	/*
	 * post Stories:
	 * A post can login
	 * A post can logout
	 */
	
//	@Transactional
//	public Posts getOnePost(String username) {
//		Session s = sf.getCurrentSession();
//		Posts a = (Posts) s.createCriteria(Posts.class)
//				.add(Restrictions.eq("username", username)).uniqueResult();
//		
//		return a;
//	}
	
	@Transactional
	public List<Posts> getAllPostsFromOneUser(String username) {
		System.out.println("boob");
		Session s = sf.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Posts> Posts = s.createCriteria(Posts.class)
			.add(Restrictions.eq("username", username)).list();
		 System.out.println(Posts.toString());
		return Posts;
	}
	
//	@Transactional(propagation = Propagation.REQUIRED)
//	public boolean updatePost(Posts post) {
//		Session s = sf.getCurrentSession();
//		Posts u = (Posts) s.get(Posts.class, post.getId());
//		
//		// insert logic to check if posts don't match up here.
//		
//		try {
//			s.persist(u);
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addNewPost(Posts post) {
		System.out.println(post.toString());
		Session s = sf.getCurrentSession();
		if (post.getUserId() == 0 || post.getUsername() == null || post.getTitle() == null
				|| post.getContent() == null)
			return false;
		try {
			s.save(post);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
//	@Transactional
//	public boolean deletePost(Posts post) {
//		
//		Session s = sf.getCurrentSession();
//		
//		Posts temp = new Posts();
//		temp.setId(post.getId());
//		
//		try {
//			s.delete(temp);
//		} catch (Exception e) {
//			return false;
//		}
//		
//		return true;
//	}

}
