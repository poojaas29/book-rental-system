package net.javaguides.brs.service.impl;

import org.springframework.stereotype.Service;

import net.javaguides.brs.entity.Role;
import net.javaguides.brs.entity.User;
import net.javaguides.brs.repository.UserRepository;
import net.javaguides.brs.service.UserService;
import net.javaguides.brs.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getName(), registrationDto.getEmail(), 
				registrationDto.getPassword(), new Role("Customer"));
		
		return userRepository.save(user);
		
		
	}

}
