package com.linkedin.ProfessionalNetworking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This class used to Enable the Login Security
 */
@Configuration
@EnableWebSecurity
public class BaseSecurityConfiguration  extends WebSecurityConfigurerAdapter {

    //FIXME: Method has to change when real time security enabled.
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/").permitAll();
    }
}