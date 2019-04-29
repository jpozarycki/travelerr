package com.pozarycki.travelerr.service.mapper;

import com.pozarycki.travelerr.domain.User;
import com.pozarycki.travelerr.domain.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {

    default User fromId (Long id){
        if (id==null){
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;

    }

}
