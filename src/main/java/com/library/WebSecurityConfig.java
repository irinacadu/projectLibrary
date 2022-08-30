package com.library;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

@Autowired
private javax.sql.DataSource dataSource;
@Autowired
private BCryptPasswordEncoder passEncoder;

@Autowired
public void configurerSecurityGlobal(AuthenticationManagerBuilder builder)throws Exception{
builder.jdbcAuthentication()
.dataSource(dataSource)
.passwordEncoder(passEncoder)
.usersByUsernameQuery("SELECT user_name, password, enabled FROM user WHERE user_name=?")
.authoritiesByUsernameQuery("SELECT u.user_name, r.rol FROM rol r INNER JOIN user u ON r.user_id=u.id WHERE u.user_name =?") ;

}

}

