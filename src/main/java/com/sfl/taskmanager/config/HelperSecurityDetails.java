package com.sfl.taskmanager.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import static java.util.Arrays.asList;

public class HelperSecurityDetails implements UserDetails {

    public static final String ROLE_USER = "USER";
    public static final String ROLE_ADMIN = "ADMIN";
    private boolean enabled;
    private String userName;
    private String password;
    private Long customerId;
    private boolean isAdmin;

    public HelperSecurityDetails(String userName, String password, boolean enabled, Long customerId, boolean isAdmin) {
        this.enabled = enabled;
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
        this.customerId = customerId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return asList(isAdmin ? new SimpleGrantedAuthority(ROLE_ADMIN) : new SimpleGrantedAuthority(ROLE_USER));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    public Long getCustomerId() {
        return customerId;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}