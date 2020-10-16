package com.project.recruitmentoperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.recruitmentoperation.dao.UserDao;
import com.project.recruitmentoperation.entity.User;


@Service

public class UserServiceImpl implements UserService{
	
	{
		System.out.println("serviceeeee");
	}

	 @Autowired
	    private UserDao userDao;

	    
	
	
	 @Override
	 @Transactional
	    public void saveCustomer(User user) {
		 userDao.saveUser(user);
	    }




	@Override
	@Transactional
	public List<User> getUsers() {
		return userDao.getUsers();
		
	}
	@Override
	@Transactional
	public User validate(String email, String password){
		System.out.println("**");
		return userDao.validate(email,password);
		
	}
	

	@Override
	@Transactional

	public User viewprofile(int id)
	{
		System.out.println("view 2"+id);
		return userDao.viewprofile(id);
	}
	

}
