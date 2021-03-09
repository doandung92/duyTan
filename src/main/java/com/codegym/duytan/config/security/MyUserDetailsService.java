package com.codegym.duytan.config.security;

import com.codegym.duytan.entity.Member;
import com.codegym.duytan.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Member> memberOptional = memberRepository.findByUsername(s);
        memberOptional.orElseThrow(()-> new UsernameNotFoundException("Not found: "+ s));
        return new MyUserDetail(memberOptional.get());
    }
    public MyUserDetail buildUserDetailsFromOauth2User(OAuth2User oAuth2User) {
        return new MyUserDetail(oAuth2User);
    }
}
