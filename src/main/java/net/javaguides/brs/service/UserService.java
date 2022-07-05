package net.javaguides.brs.service;

import net.javaguides.brs.entity.User;
import net.javaguides.brs.web.dto.UserRegistrationDto;

public interface UserService {
	
	User save(UserRegistrationDto registrationDto);
	
	

}
