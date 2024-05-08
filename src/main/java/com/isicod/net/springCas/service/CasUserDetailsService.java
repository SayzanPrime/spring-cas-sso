package com.isicod.net.springCas.service;

import com.isicod.net.springCas.models.CasUser;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.cas.authentication.CasAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CasUserDetailsService implements AuthenticationUserDetailsService {

    @Override
    public UserDetails loadUserDetails(Authentication token) throws UsernameNotFoundException {
        CasAssertionAuthenticationToken casAssertionAuthenticationToken = (CasAssertionAuthenticationToken) token;
        AttributePrincipal principal = casAssertionAuthenticationToken.getAssertion().getPrincipal();
        Map<String, Object> attributes = principal.getAttributes();

        CasUser casUser = new CasUser(attributes);

        Collection<SimpleGrantedAuthority> roles = new ArrayList<>();
        for (String role: casUser.getEduPersonAffiliation()) {
            roles.add(new SimpleGrantedAuthority(role));
        }

        return new User(casUser.getDisplayName(), "", roles);
    }

    public CasUser getCurrentLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CasAuthenticationToken casAuthenticationToken = (CasAuthenticationToken) authentication;
        AttributePrincipal principal = casAuthenticationToken.getAssertion().getPrincipal();
        Map<String, Object> attributes = principal.getAttributes();
        return new CasUser(attributes);
    }
}