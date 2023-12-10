package com.ls.domain;


import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

public class UserRole implements GrantedAuthority {

    private Role role;

    @Override
    public String getAuthority() {
        return role.getName();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(role, userRole.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }
}