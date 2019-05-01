package com.pozarycki.travelerr.web.errors;

public class UserNameAlreadyUsedException extends BadRequestAlertException {

    private static final long serialVersionUID = 1L;

    public UserNameAlreadyUsedException() {
        super(ErrorConstants.USER_NAME_ALREADY_USED_TYPE, "Username is already in use!", "userManagement", "usernameexists");    }
}
