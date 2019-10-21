package com.revature.repositories;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.revature.beans.Photos;
import com.revature.beans.Posts;
import com.revature.beans.Users;

@Repository
public class PhotosDAO {

	@Autowired
	private SessionFactory sf;
	
	/*
	 * photo Stories:
	 * A photo can login
	 * A photo can logout
	 */
	
//	@Transactional
//	public Photos getOnePhoto(long id) {
//		Session s = sf.getCurrentSession();
//		Photos a = (Photos) s.get(Photos.class, id);
//		
//		return a;
//	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Photos> getRecentPhotos() {
		Session s = sf.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Photos> p = s.createCriteria(Photos.class).list();
		int i = p.size() - 1;
		int n = 0;
		List<Photos> k = new ArrayList<Photos>();
		while (n < 5) {
			k.add(p.get(i));
			i--;
			n++;
		}
		return k;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Photos> getAllPhotosFromOneUser(String username) {
		Session s = sf.getCurrentSession();
		
		Users u = null;
		u = (Users) s.createCriteria(Users.class).add(Restrictions.eq("username", username)).uniqueResult();
		long usersId = u.getId();
		@SuppressWarnings("unchecked")
		List<Photos> Photos = s.createCriteria(Photos.class)
			.add(Restrictions.eq("usersId", usersId)).list();
		return Photos;
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addNewPhoto(byte[] bytes, long id) {
		
		
		Session s = sf.getCurrentSession();
		
		Photos photo = new Photos();
		photo.setUsersId(id);
		//photo.setUsersId(9);
		photo.setId(0);
		photo.setImg(bytes);
		System.out.println(id);
		try {
			s.persist(photo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static byte[] ImageToByte(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			
			try {
				for (int i; (i = fis.read(buf)) != -1;) {
					bos.write(buf, 0, i);
					//System.out.println("read " + i + " bytes, ");
				}
			}catch (IOException e) {
			}
			byte[] bytes = bos.toByteArray();
			return bytes;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
