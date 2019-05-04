package com.pozarycki.travelerr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * Warning! Configuration only for development only. DO NOT use in production!
 */


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler;
    private final AuthenticationEntryPoint restAuthenticationEntryPoint;
    private final CustomAuthenticationFailureHandler myFailureHandler;

    public SecurityConfiguration(
            MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler,
            AuthenticationEntryPoint restAuthenticationEntryPoint,
            CustomAuthenticationFailureHandler myFailureHandler) {
        this.mySuccessHandler = mySuccessHandler;
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
        this.myFailureHandler = myFailureHandler;
    }

    @Override
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

        httpSecurity
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/api/foos").authenticated()
                .antMatchers("/api/admin/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .successHandler(mySuccessHandler)
                .failureHandler(myFailureHandler)
                .and()
                .logout();

    }

    /**
     * Configuration of authentication of API endpoints. Only for dev, DO NOT use in prod
     */

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("admin").password(encoder().encode("admin")).roles("ADMIN")
                .and()
                .withUser("user").password(encoder().encode("user")).roles("USER");

    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


}
