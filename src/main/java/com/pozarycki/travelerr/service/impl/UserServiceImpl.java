package com.pozarycki.travelerr.service.impl;

import com.pozarycki.travelerr.domain.User;
import com.pozarycki.travelerr.domain.dto.LocationDTO;
import com.pozarycki.travelerr.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findByUserName(String userName) {
        return null;
    }

    @Override
    public Set<User> findAll() {
        return null;
    }

    @Override
    public Optional<LocationDTO> findById(Long aLong) {
        return null;
    }

    @Override
    public User save(User object) {
        return null;
    }

    @Override
    public void delete(User object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
