package com.yemmback.store.controller;
 
import com.yemmback.store.exception.ResourceNotFoundException;
import com.yemmback.store.model.Employee;
import com.yemmback.store.model.User;
import com.yemmback.store.model.colections.Target;
import com.yemmback.store.payload.reponse.ApiResponse;
import com.yemmback.store.payload.request.UserRequest;
import com.yemmback.store.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/data")
public class UserController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    // Find
    @GetMapping("/users")
    List<User> findAll() {
        return userRepository.findUsers(0);
    }

    // Save
    @PostMapping("/adduser")
    @ResponseStatus(HttpStatus.CREATED)
    User newUser(@Valid @RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    // Find
    @GetMapping("/user/{id}")
    User findOne(@PathVariable @Min(1) Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException( "User", " Resource Not Found ", id));
    }

    // Save or update
    @PutMapping("/user")
    ResponseEntity<?> saveOrUpdate(@RequestBody UserRequest newUser) {

        User user= new User();

        if(newUser.getId()==null){
            if(userRepository.existsByUsername(newUser.getUsername())) {
                return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                        HttpStatus.BAD_REQUEST);
            }
            if(userRepository.existsByEmail(newUser.getEmail())) {
                    return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                        HttpStatus.BAD_REQUEST);
            }
              user = new User(null, newUser.getUsername(),
                    newUser.getEmail(), newUser.getPassword(), 0, newUser.getRole(),
                    Target.sadmin, null) ;
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }else {
            user=userRepository.getOne(newUser.getId());
            if(user.getId()>0){
                user.setUsername(newUser.getUsername());
                user.setEmail(newUser.getEmail());
                user.setTarget(newUser.getTarget());
                user.setPeopleid(newUser.getPeopleid());
            }
        }
       /* User x=(newUser.getId()!=null || newUser.getPeopleid()<=0)?userRepository.getOne(newUser.getId()):
                new User(newUser.getUsername(), newUser.getEmail(),passwordEncoder.encode("passer"), 0, newUser.getRole(), newUser.getTarget(), newUser.getPeopleid());*/
          /*User x=userRepository.getOne(newUser.getId());
                x.setId((x.getId()>0)?newUser.getId():null);
                x.setUsername(newUser.getUsername());
                x.setEmail(newUser.getEmail());
                x.setPassword((x.getId()>0)?newUser.getPassword():passwordEncoder.encode("passer"));
                 x.setFlaguser((x.getId()>0)?newUser.getFlaguser():0);
                x.setTarget(newUser.getTarget());
                x.setPeopleid(newUser.getPeopleid());*/
          //userRepository.save(x);


        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(userRepository.save(user).getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User saved successfully "+String.valueOf(user.getId())));
      //  return ResponseEntity.created(location).body(new ApiResponse(true, "User saved successfully",user));
    }

    // Find
    @GetMapping("/deluser/{id}")
    ResponseEntity<?> delete(@PathVariable @Min(1) Long id) {

       User user=userRepository.getOne(id);user.setFlaguser(1);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(userRepository.save(user).getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User "+String.valueOf(id)+" successfully deleted "));
    }

}
