package com.pozarycki.travelerr.web.controller;

import com.pozarycki.travelerr.domain.User;
import com.pozarycki.travelerr.domain.dto.UserDTO;
import com.pozarycki.travelerr.repository.UserRepository;
import com.pozarycki.travelerr.service.UserService;
import com.pozarycki.travelerr.service.mapper.UserMapper;
import com.pozarycki.travelerr.web.errors.BadRequestAlertException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository, UserMapper userMapper) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        List<UserDTO> userDTOList = userService.findAll();
        return new ResponseEntity<List<UserDTO>>(userDTOList, HttpStatus.OK);

    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<UserDTO>> getUserById(@PathVariable Long id) {

        Optional<UserDTO> userDTO = userService.findById(id);
        return new ResponseEntity<Optional<UserDTO>>(userDTO, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO){

        if(userService.findById(userDTO.getId()).isPresent()) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        User registeredUser = userService.registerUser(userDTO);
        userRepository.save(registeredUser);

        return new ResponseEntity<Void>(HttpStatus.CREATED);

    }

    @PutMapping("/users")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){

        if(userDTO.getId().equals(null)){
            throw new BadRequestAlertException("Invalid ID", "User", "idnull");
        }

        UserDTO resultUserDto = userService.save(userDTO);
        return new ResponseEntity<UserDTO>(resultUserDto, HttpStatus.OK);

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){

        userService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

}
