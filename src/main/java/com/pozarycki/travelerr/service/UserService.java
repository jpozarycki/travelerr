package com.pozarycki.travelerr.service;

import com.pozarycki.travelerr.domain.dto.UserDTO;

public interface UserService extends CrudService<UserDTO, Long>{

    UserDTO findByUserName(String userName);


}
