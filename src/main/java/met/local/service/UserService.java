package met.local.service;

import met.local.model.User;
import met.local.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);

	User saveUser(User user);


}
