package com.scp.controller;

import javax.swing.text.html.FormSubmitEvent.MethodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.scp.bean.UserBean;
import com.scp.model.UserEntity;
import com.scp.service.UserService;
import com.scp.service.impl.UserServiceImpl;
import com.scp.service.UserService;
import com.scp.model.UserEntity;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public ModelAndView appLandingPage(){
		//ModelAndView model = new ModelAndView();
		//model.addObject("userbean",new UserBean());
		return new ModelAndView("users");
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") UserBean bean){
		System.out.println("In Add--------------------------------------------");
		if(bean.getUserId() == 0){
			this.userService.addUser(bean);
		}
		else{
			this.userService.updateUser(bean);
		}
		return "redirect:/users";
	}
	
	@RequestMapping(value="/remove/{userId}",method=RequestMethod.GET)
	public String deleteUser(@PathVariable int userId){
		userService.deleteUser(userId);
		return "redirect:/users";
	}
	
	 @RequestMapping(value="/edit/{userId}",method=RequestMethod.GET)
	    public String editUser(@PathVariable("userId") int userId, Model model){
	        model.addAttribute("user", this.userService.getUser(userId));
	        model.addAttribute("listUsers", this.userService.getUsers());
	        return "user";
	    }
	
	@RequestMapping(value="/getuser/{userId}",method=RequestMethod.GET)
	public UserBean getUser(@PathVariable("userId") int userId){
		return userService.getUser(userId);
	}
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String getListOfUsers(Model model){
		model.addAttribute("user", new UserEntity());
		model.addAttribute("listUsers", this.userService.getUsers());
		return "user";
	}
}

