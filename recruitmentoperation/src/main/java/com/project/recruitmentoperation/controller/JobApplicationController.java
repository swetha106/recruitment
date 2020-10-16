package com.project.recruitmentoperation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.recruitmentoperation.entity.JobProcessDetails;
import com.project.recruitmentoperation.entity.User;
import com.project.recruitmentoperation.service.JobApplicationService;
import com.project.recruitmentoperation.service.UserService;

@Controller
@SessionAttributes({"usersession","jobsession"})
public class JobApplicationController {
	 @Autowired
	    private JobApplicationService JobApplicationService;
	 @Autowired
	    private UserService userService;
	
	 @RequestMapping(value = "/jobapplication")
	  public ModelAndView jobapplication(@RequestParam("id") int id) {
	//	 System.out.println("ffoorrmm");
	    ModelAndView mav = new ModelAndView("jobapplication");
	   User user=userService.viewprofile(id);
	    mav.addObject("job", new JobProcessDetails());
	    mav.addObject("usersession",user);
        
  	    return mav;
	    
	  }
	 
	 @RequestMapping(value = "/uploadresume", method = RequestMethod.POST)
	    public ModelAndView handleFileUpload(@ModelAttribute("job")  JobProcessDetails job) throws Exception {
	          
		 ModelAndView mav=new   ModelAndView("userpage");
	            //    System.out.println("Saving file: " + aFile.getOriginalFilename());
	                 
	             //   JobProcessDetails uploadFile = new JobProcessDetails();
	                JobApplicationService.save(job);   
	            //    mav.addObject("jobsession",job);
	   			 
	  
	        return mav;
	    }  
/*	 @RequestMapping(value = "/uploadresume", method = RequestMethod.POST)
	  public String handleFileUpload() throws Exception {
		 
		  return "home";
	 }
*/
}
