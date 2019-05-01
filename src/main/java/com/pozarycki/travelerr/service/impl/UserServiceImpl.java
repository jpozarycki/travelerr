package com.pozarycki.travelerr.service.impl;

import com.pozarycki.travelerr.domain.User;
import com.pozarycki.travelerr.domain.dto.UserDTO;
import com.pozarycki.travelerr.repository.UserRepository;
import com.pozarycki.travelerr.security.SecurityUtils;
import com.pozarycki.travelerr.service.UserService;
import com.pozarycki.travelerr.service.mapper.UserMapper;
import com.pozarycki.travelerr.web.errors.EmailAlreadyUsedException;
import com.pozarycki.travelerr.web.errors.InvalidPasswordException;
import com.pozarycki.travelerr.web.errors.UserNameAlreadyUsedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    // todo - implement password encoder

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<UserDTO> findByUserName(String userName) {
        return userRepository.findOneByUserName(userName)
                .map(userMapper::toDto);
    }

    @Override
    public User registerUser(UserDTO userDTO) {
        if (userRepository.findOneByEmail(userDTO.getEmail()).isPresent()) {
            throw new EmailAlreadyUsedException();
        }
        if (userRepository.findOneByUserName(userDTO.getUserName()).isPresent()){
            throw new UserNameAlreadyUsedException();
        }
        User newUser = new User();

        newUser.setUserName(userDTO.getUserName());
        newUser.setPassword(userDTO.getPassword()); // make it encrypted
        newUser.setEmail(userDTO.getEmail());

        if (!userDTO.getFirstName().isEmpty()){
            newUser.setFirstName(userDTO.getFirstName());

        }

        if (!userDTO.getLastName().isEmpty()){
            newUser.setLastName(userDTO.getLastName());

        }

        userRepository.save(newUser);

        return newUser;
    }

    @Override
    public void changePassword(String currentPassword, String newPassword) {
        SecurityUtils.getCurrentUserUserName()
                .flatMap(userRepository::findOneByUserName)
                .ifPresent(user -> {
                    if ( currentPassword.matches(user.getPassword())){
                        user.setPassword(newPassword);
                    } else {
                        throw new InvalidPasswordException();
                    }
                });
    }

    @Override
    public void updateUser(String newFirstName, String newLastName, String newEmail) {
        SecurityUtils.getCurrentUserUserName()
                .flatMap(userRepository::findOneByUserName)
                .ifPresent(user -> {
                    user.setFirstName(newFirstName);
                    user.setLastName(newLastName);
                    user.setEmail(newEmail);
                });

    }

    @Override
    public Optional<UserDTO> updateUser(UserDTO userDTO) {
        return Optional.of(userRepository
        .findById(userDTO.getId()))
        .filter(Optional::isPresent)
                .map(Optional::get)
                .map(user -> {
                    user.setUserName(userDTO.getUserName());
                    user.setPassword(userDTO.getPassword());
                    user.setEmail(userDTO.getEmail());
                    user.setFirstName(userDTO.getFirstName());
                    user.setLastName(userDTO.getLastName());
                    return user;
                })
                .map(UserDTO::new);


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
