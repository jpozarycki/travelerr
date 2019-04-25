package com.pozarycki.travelerr.service;

import com.pozarycki.travelerr.model.User;

public interface UserService extends CrudService<User, Long>{

    User findByUserName(String userName);


}
