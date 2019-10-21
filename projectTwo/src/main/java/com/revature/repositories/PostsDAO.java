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
import com.revature.beans.Users;

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
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Posts> getAllPostsFromOneUser(String username) {
		System.out.println("boob");
		Session s = sf.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Posts> p = s.createCriteria(Posts.class)
			.add(Restrictions.eq("username", username)).list();							
		if (!(p.isEmpty()))
			return p;
		else
			return null;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Posts> getRecentPosts() {
		Session s = sf.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Posts> p = s.createCriteria(Posts.class).list();
		int i = p.size() - 1;
		int n = 0;
		List<Posts> k = new ArrayList<Posts>();
		while (n < 5) {
			k.add(p.get(i));
			i--;
			n++;
		}
		return k;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addNewPost(Posts post) {
		System.out.println(post.toString());
		Session s = sf.getCurrentSession();
		if (post.getUserId() == 0 || post.getUsername() == null || post.getTitle() == null
				|| post.getContent() == null) return false;
		
		Users u;
		
		u = (Users) s.createCriteria(Users.class).add(Restrictions.eq("username",
				post.getUsername())).add(Restrictions.eq("id", post.getUserId())).uniqueResult();
		if (u == null)
			 return false;
		if (post.getContent().isEmpty())
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
