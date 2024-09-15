package uteam.b1_project_erp_education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uteam.b1_project_erp_education.payload.SignUpDto;
import uteam.b1_project_erp_education.repository.AuthRepository;
import uteam.b1_project_erp_education.repository.RoleRepository;

// services/AuthService.java
@Service
public class AuthService implements UserDetailsService {

    @Autowired
    AuthRepository repository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = repository.findByUserName(username);
        return user;
    }

//    public UserDetails signUp(SignUpDto data) throws InvalidJwtException {
//        if (repository.findByUserName(data.login()) != null) {
//            throw new InvalidJwtException("Username already exists");
//        }
//        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
//        User newUser = new User(data.login(), encryptedPassword, roleRepository.findById(data.roleId()).get().getRoleName());
//        return repository.save(newUser);
//    }
}