package config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.satyam.foodforgood.model.OrganisationInformation;
import com.satyam.foodforgood.repository.OrganisationInformationRepository;

public class UserDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	OrganisationInformationRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		OrganisationInformation user = userRepository.findByEmail(username);
		
		if(user == null) {
			throw new RuntimeException("User with the given username: "+username+" not found.");
		}
		
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		
		return customUserDetails;
	}

}
