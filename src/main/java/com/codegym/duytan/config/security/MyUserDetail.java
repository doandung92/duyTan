package com.codegym.duytan.config.security;

import com.codegym.duytan.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetail implements UserDetails {

    private String userName;
    private String password;
    private String email;
    private List<GrantedAuthority> authorities;

    public MyUserDetail() {
    }
    public MyUserDetail(OAuth2User oAuth2User) {
        this.userName = oAuth2User.getAttribute("username");
        this.password = oAuth2User.getAttribute("password");
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }
    public MyUserDetail(Member user){
        this.userName = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.authorities = Arrays.stream(user.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
