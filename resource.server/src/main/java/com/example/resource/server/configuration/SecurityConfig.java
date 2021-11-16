package com.example.resource.server.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.cors()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/account")
                .hasAuthority("SCOPE_customer")
                .antMatchers(HttpMethod.POST, "/api/account")
                .hasAuthority("SCOPE_banker")
                .antMatchers(HttpMethod.GET, "/api/account/all")
                .hasAuthority("SCOPE_banker")
                .antMatchers(HttpMethod.PUT, "/api/account/changeBalance")
                .hasAuthority("SCOPE_banker")
                .anyRequest()
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();
        //@formatter:on
    }
}
