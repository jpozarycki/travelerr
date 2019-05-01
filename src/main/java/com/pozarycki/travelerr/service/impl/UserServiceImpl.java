package com.pozarycki.travelerr.service.impl;

import com.pozarycki.travelerr.domain.User;
import com.pozarycki.travelerr.domain.dto.UserDTO;
import com.pozarycki.travelerr.repository.UserRepository;
import com.pozarycki.travelerr.service.UserService;
import com.pozarycki.travelerr.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<UserDTO> findByUserName(String userName) {
        return userRepository.findByUserName(userName)
                .map(userMapper::toDto);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findById(Long aLong) {
        return userRepository.findById(aLong)
                .map(userMapper::toDto);
    }

    @Override
    public UserDTO save(UserDTO object) {
        User userSaved = userMapper.toEntity(object);
        userRepository.save(userSaved);
        return userMapper.toDto(userSaved);
    }

    @Override
    public Optional<Void> delete(UserDTO object) {
        userRepository.delete(userMapper.toEntity(object));
        return Optional.empty();
    }

    @Override
    public Optional<Void> deleteById(Long aLong) {
        userRepository.deleteById(aLong);
        return Optional.empty();
    }
}
