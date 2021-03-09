package com.codegym.duytan.config.security;

import com.codegym.duytan.handler.OAuth2LoginSuccessHandler;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.oauth2.client.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.registration.*;
import org.springframework.security.web.util.matcher.*;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
    @Autowired
    private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;

    @Autowired
    private MyUserDetailsService userDetailsService;
//
//    @Value("${google.app.id}")
//    String clientId ;
//
//    @Value("${google.app.secret}")
//    String clientSecret;
//
////    @Bean
////    public BCryptPasswordEncoder getPasswordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(getPasswordEncoder());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/oauth2/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin().loginPage("/login")
                    .permitAll()
                .and()
                    .oauth2Login().successHandler(oAuth2LoginSuccessHandler)
                    .loginPage("/login").clientRegistrationRepository(clientRegistrationRepository())
                    .authorizedClientService(authorizedClientService())
                .and()
                    .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }


    private ClientRegistration getRegistration(String client) {
        String clientId = GoogleAPI.clientId;
        String clientSecret = GoogleAPI.clientSecret;
        return CommonOAuth2Provider.GOOGLE.getBuilder(client)
                .clientId(clientId).clientSecret(clientSecret).build();
    }

    @Bean
    public OAuth2AuthorizedClientService authorizedClientService() {
        return new InMemoryOAuth2AuthorizedClientService(
                clientRegistrationRepository());
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration registration = getRegistration("google");
        return new InMemoryClientRegistrationRepository(registration);
    }


}
