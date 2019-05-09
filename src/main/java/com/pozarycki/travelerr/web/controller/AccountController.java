package com.pozarycki.travelerr.web.controller;

import com.pozarycki.travelerr.domain.dto.PasswordChangeDTO;
import com.pozarycki.travelerr.repository.UserRepository;
import com.pozarycki.travelerr.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountController {

    private final UserRepository userRepository;
    private final UserService userService;

    public AccountController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PutMapping("/account/change-password")
    public void changePassword(@RequestBody PasswordChangeDTO passwordChangeDTO) {

        userService.changePassword(passwordChangeDTO.getCurrentPassword(), passwordChangeDTO.getNewPassword());
    }
}
