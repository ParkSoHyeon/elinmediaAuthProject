package com.dso.security;

import com.dso.domain.WideAdmin;
import com.dso.domain.WideRole;
import com.dso.persistence.WideAdminRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log
public class WideUserService implements UserDetailsService {
    private static final String ROLE_PREFIX = "ROLE_";

    private WideAdmin wideAdmin;

    @Autowired
    private WideAdminRepository wideAdminRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return wideAdminRepository.findById(username)
                .filter(admin -> (admin != null) && (admin.getWideAdminContractStatusCode().equals("CY")))
                .map(admin -> new User(admin.getWideAdminEmail()
                        , admin.getWideAdminPassword()
                        , makeGrantedAuthority(admin.getWideAdminRoleCode()))).get();
    }

    private static List<GrantedAuthority> makeGrantedAuthority(List<WideRole> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getWideRoleCode())));

        return authorities;
    }
}
