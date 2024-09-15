package uteam.b1_project_erp_education.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import uteam.b1_project_erp_education.entity.Users;
import uteam.b1_project_erp_education.payload.JwtDto;
import uteam.b1_project_erp_education.payload.SignInDto;
import uteam.b1_project_erp_education.repository.AuthRepository;
import uteam.b1_project_erp_education.security.JwtTokenProvider;
import uteam.b1_project_erp_education.service.AuthService;

// controllers/AuthController.java
@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthService service;
    @Autowired
    private JwtTokenProvider tokenService;
    @Autowired
    AuthRepository authRepository;
//
//    @PostMapping("/signup")
//    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpDto data) {
//        service.signUp(data);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }

    @GetMapping("/get-me/{username}")
    public HttpEntity<?> getUserMe(@PathVariable String username) {
        UserDetails byUserName = authRepository.findByUserName(username);
        if (byUserName != null) {
            return ResponseEntity.ok(byUserName);
        }
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> signIn(@RequestBody @Valid SignInDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authUser = authenticationManager.authenticate(usernamePassword);
        var accessToken = tokenService.generateAccessToken((Users) authUser.getPrincipal());
        return ResponseEntity.ok(new JwtDto(accessToken));
    }
}