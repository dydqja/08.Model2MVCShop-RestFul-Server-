package com.model2.mvc.web.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.user.UserService;


//==> 회원관리 RestController
@RestController
@RequestMapping("/user/*")
public class UserRestController {
	
	///Field
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	//setter Method 구현 않음
	
	
	public UserRestController(){
		System.out.println(this.getClass());
	}
	/*
	@RequestMapping( value="json/addUser", method=RequestMethod.POST)
	public String addUser(@RequestBody User user) throws Exception {
		
		System.out.println("[From Client Data]");
		
		System.out.println("1:"+user);
		
		userService.addUser(user);	
		
		
		return null;
	}
	
	
	
	@RequestMapping( value="json/getUser/{userId}", method=RequestMethod.GET )
	public User getUser( @PathVariable String userId ) throws Exception{
		
		System.out.println("/user/json/getUser : GET");
		
		//Business Logic
		return userService.getUser(userId);
	}

	@RequestMapping( value="json/login", method=RequestMethod.POST )
	public User login(		@RequestBody User user,
										HttpSession session ) throws Exception{
	
		System.out.println("/user/json/login : POST");
		//Business Logic
		System.out.println("::"+user);
		User dbUser=userService.getUser(user.getUserId());
		
		if( user.getPassword().equals(dbUser.getPassword())){
			session.setAttribute("user", dbUser);
		}
		
		return dbUser;
	} */
	
	//================================================================//
	//                    08 Repector 추가부분 
	// 2.POST방식 JsonSimple => getUserTest (23.02.28) ing
	//						 => map 으로 받기
	//================================================================//
	
	@RequestMapping(value = "json/getUser/{value}", method = RequestMethod.POST)
	public Map getUser(@PathVariable String value) throws Exception {
		
		System.out.println("[From Client Data]");
		System.out.println(value);		
				
		//Business Logic
		System.out.println("[To Client Data]");
		User ReturnUser = userService.getUser(value);
		System.out.println(ReturnUser);	
		
		Map map = new HashMap();
		map.put("ReturnUser", ReturnUser);
		
		return map;
		
	}	
	
}