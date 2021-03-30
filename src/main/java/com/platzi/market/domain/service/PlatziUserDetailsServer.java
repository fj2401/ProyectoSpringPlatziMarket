package com.platzi.market.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlatziUserDetailsServer implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("oscar", "{noop}platzi", new ArrayList<>());
    }
    /*
    * El correcto seria conectarlo a una base de datos para que verifique el correcto funcionamiento
    * o el correcto inicio de seccion antes de usar nuestros servicios
    * */
}
