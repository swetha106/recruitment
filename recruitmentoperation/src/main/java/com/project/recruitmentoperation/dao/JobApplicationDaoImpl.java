package com.project.recruitmentoperation.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.recruitmentoperation.entity.JobProcessDetails;

@Repository
public class JobApplicationDaoImpl implements JobApplicationDao {
	  @Autowired
	    private SessionFactory sessionFactory;
	  
	  
	     
	    public JobApplicationDaoImpl() {
	    }
	 
	    public JobApplicationDaoImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	 
	    @Override
	    @Transactional
	    public void save(JobProcessDetails uploadFile) {
	        sessionFactory.getCurrentSession().save(uploadFile);
	    }
  
}
