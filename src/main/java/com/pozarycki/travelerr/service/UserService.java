package com.pozarycki.travelerr.service;

import com.pozarycki.travelerr.domain.User;

public interface UserService extends CrudService<User, Long>{

    User findByUserName(String userName);


}
