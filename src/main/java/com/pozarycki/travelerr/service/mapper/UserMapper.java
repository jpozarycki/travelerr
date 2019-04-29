package com.pozarycki.travelerr.service.mapper;

import com.pozarycki.travelerr.domain.User;
import com.pozarycki.travelerr.domain.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO (User user);

    User userDTOToUser (UserDTO userDTO);
}
