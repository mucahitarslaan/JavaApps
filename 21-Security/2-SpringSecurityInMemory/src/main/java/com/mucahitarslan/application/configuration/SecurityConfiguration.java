package com.mucahitarslan.application.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        //http.formLogin(); //first login page
        http.authorizeHttpRequests()
                .antMatchers("/dashboard")
                .hasAnyRole("admin","user")
                .antMatchers("/admin").hasAnyRole("admin")
                .and()
                .authorizeHttpRequests()
                .antMatchers("/index")
                .permitAll();
    }

    @Override //application.properties off
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}1234").roles("admin")
                .and()
                .withUser("ali").password("{noop}1234").roles("user");
    }
}
