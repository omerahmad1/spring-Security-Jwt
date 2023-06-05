package com.spring.security.jwt.Services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.security.jwt.Entities.Users;
import com.spring.security.jwt.Exception.CustomException;
import com.spring.security.jwt.Models.CreateUserRequest;
import com.spring.security.jwt.Models.CreateUserResponse;
import com.spring.security.jwt.Repositories.UsersRepository;

@Service
public class UserService {
	@Value("${key}")
	private String key;

	protected static final Logger logger = LoggerFactory.getLogger(UserService.class.getName());
	@Autowired
	UsersRepository usersRepository;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public CreateUserResponse createUser(CreateUserRequest request, CreateUserResponse response)
			throws CustomException {
		logger.debug("Request: " + request);
		Users user = new Users();
//		user = usersRepository.findByUsername(request.getUsername());
//		if (user != null ) {
//			throw new CustomException("User already exist.Please Try Another one");
//		}

		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setUsername(request.getUsername());
		String encodedPassword = passwordEncoder.encode(request.getPassword());
		user.setPassword(encodedPassword);
		usersRepository.save(user);
		logger.debug("Users : " + user.getUsername());
		System.out.println("Request : " + key);
		response.setCode("200");
		response.setMessage("Successfully SignUp");
		logger.debug("Response : " + response);
		return response;
	}

}
