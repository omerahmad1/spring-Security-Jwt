package com.spring.security.jwt.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.security.jwt.Exception.CustomException;
import com.spring.security.jwt.Models.CreateUserRequest;
import com.spring.security.jwt.Models.CreateUserResponse;
import com.spring.security.jwt.Services.UserService;


@RestController
@RequestMapping(path = "/user")
public class UsersControllers {
	
	@Value("${key}")
	private String key;
//	@Value("${value.from.file}")
//	private String valueFromFile;
//	@Value("${priority}")
//	private String prioritySystemProperty;
//	@Value("${listOfValues}")
//	private String arrayValue;
	
	protected static final Logger logger = LoggerFactory.getLogger(UsersControllers.class.getName());
	@Autowired
	UserService userService;
	@PostMapping("/signup")
	public CreateUserResponse createUser(@RequestBody CreateUserRequest request) throws CustomException {
		logger.debug("Request : " + request);
		System.out.println("Request : "+ key);
		CreateUserResponse response  = new CreateUserResponse();
		response=userService.createUser(request,response);
		logger.debug("Response: " + response);
		return response;
	}

}
