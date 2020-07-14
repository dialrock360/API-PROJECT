package com.yemmback.store.controller;

import com.yemmback.store.model.User;
import com.yemmback.store.model.colections.Target;
import com.yemmback.store.payload.dto.UserSummary;
import com.yemmback.store.payload.reponse.ApiResponse;
import com.yemmback.store.payload.request.JwtAuthenticationResponse;
import com.yemmback.store.payload.request.UserRequest;
 import com.yemmback.store.repository.UserRepository;
import com.yemmback.store.security.CurrentUser;
import com.yemmback.store.security.JwtTokenProvider;
import com.yemmback.store.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.net.URI;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;


    @Autowired
    PasswordEncoder passwordEncoder;


    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );
        User user = userRepository.findBylogin(loginRequest.getUsernameOrEmail());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
         System.out.println("---------------------------------------------------------------------"+jwt);
        JwtAuthenticationResponse jawt = new JwtAuthenticationResponse(jwt);
        jawt.setUser(new UserRequest(user.getId(), user.getUsername(), user.getEmail(), user.getRole(),user.getTarget(),user.getPeopleid(),  user.getFlaguser(),   jwt));
        return ResponseEntity.ok(jawt);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRequest signUpRequest) {
        String userlogin =signUpRequest.getUsername();
        if(userRepository.existsByUsername(userlogin)) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }
          userlogin =signUpRequest.getEmail();
        if(userRepository.existsByEmail(userlogin)) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        /*User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword(),signUpRequest.getRole());*/
        // Creating user's account
        User user = new User(null, signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword(), 0, signUpRequest.getRole(),
                Target.sadmin, null) ;

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //user.setRole(signUpRequest.getRole());

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserRequest signUpRequest) {
        String userlogin =signUpRequest.getUsername();
        User user= userRepository.getOne(signUpRequest.getId());
        if(user==null) {
            return new ResponseEntity(new ApiResponse(false, "User is not found!"),
                    HttpStatus.BAD_REQUEST);
        }


        // Set user's account
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        //user.setRole(signUpRequest.getRole());

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User Update successfully"));
    }

    @GetMapping("/me")

    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
         return new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getEmail());
    }

}
