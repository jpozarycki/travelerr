package com.pozarycki.travelerr.service;

import com.pozarycki.travelerr.domain.dto.UserDTO;

import java.util.Optional;

public interface UserService extends CrudService<UserDTO, Long>{

    Optional<UserDTO> findByUserName(String userName);


}
