package com.project.recruitmentoperation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.recruitmentoperation.dao.JobApplicationDao;
import com.project.recruitmentoperation.entity.JobProcessDetails;

@Service
public class JobApplicationServiceImpl implements JobApplicationService{
	
	
	 @Autowired
	    private JobApplicationDao jobApplicationDao;


		@Override
		@Transactional

	public void	save (JobProcessDetails upload)
	 {
		 jobApplicationDao.save(upload);
	 }
}
