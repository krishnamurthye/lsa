package com.ls.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthUser {
    Authentication getAuthentication();
    String getName();
    UserDetails getUserDetails();
}
