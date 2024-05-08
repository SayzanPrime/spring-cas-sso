package com.isicod.net.springCas.security;

import org.jasig.cas.client.session.SingleSignOutFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@EnableWebSecurity
public class WebSecurityConfig {
    private final SingleSignOutFilter singleSignOutFilter;
    private final LogoutFilter logoutFilter;
    private final CasAuthenticationProvider casAuthenticationProvider;
    private final ServiceProperties serviceProperties;

    @Autowired
    public WebSecurityConfig(SingleSignOutFilter singleSignOutFilter, LogoutFilter logoutFilter,
                             CasAuthenticationProvider casAuthenticationProvider,
                             ServiceProperties serviceProperties) {
        this.logoutFilter = logoutFilter;
        this.singleSignOutFilter = singleSignOutFilter;
        this.serviceProperties = serviceProperties;
        this.casAuthenticationProvider = casAuthenticationProvider;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers( "/protected", "/login").authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint())
                .and()
                .addFilterBefore(singleSignOutFilter, CasAuthenticationFilter.class)
                .addFilterBefore(logoutFilter, LogoutFilter.class)
                .csrf().ignoringAntMatchers("/exit/cas");
        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(casAuthenticationProvider)
                .build();
    }

    public AuthenticationEntryPoint authenticationEntryPoint() {
        CasAuthenticationEntryPoint entryPoint = new CasAuthenticationEntryPoint();
        entryPoint.setLoginUrl("https://cas.isicod.net/cas/login");
        entryPoint.setServiceProperties(serviceProperties);
        return entryPoint;
    }
}