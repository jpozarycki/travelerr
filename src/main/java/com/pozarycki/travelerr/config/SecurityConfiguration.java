package com.pozarycki.travelerr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Warning! Configuration only for development only. DO NOT use in production!
 */


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        /**
         * Allow all requests to root url
         * Allow all requests to the H2 database console url ("/console/*")
         */
        httpSecurity.authorizeRequests().antMatchers("/").permitAll().and()
                .authorizeRequests().antMatchers("/console/**").permitAll();

        // Disable CSRF (Cross-Site Request Forgery)
        httpSecurity.csrf().disable();

        //Disable X-Frame-Options that prevents click jacking attacks - needs to be updated for prod
        httpSecurity.headers().frameOptions().disable();
    }
}
