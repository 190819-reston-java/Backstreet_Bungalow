package com.revature.repositories;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
	public List<Photos> getAllPhotosFromOneUser(String username) {
		Session s = sf.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Photos> Photos = s.createCriteria(Photos.class)
			.add(Restrictions.eq("username", username)).list();
		
		return Photos;
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addNewphoto(File file, HttpServletRequest request) {
		
		
		Session s = sf.getCurrentSession();
		
		Photos photo = new Photos();
		if (request.getSession().getAttribute("id") == null)
			return false;
		photo.setId((long) request.getSession().getAttribute("id"));
		photo.setImg(ImageToByte(file));
		try {
			s.save(photo);
		} catch (Exception e) {
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
