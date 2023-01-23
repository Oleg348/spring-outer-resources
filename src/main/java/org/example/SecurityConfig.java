package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ADMIN_ROLE = "ADMIN";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/private/**")
                    .hasRole(ADMIN_ROLE)
                .anyRequest()
                    .permitAll()
                .and()
                .formLogin();
    }

    @Autowired
    public void addUsers(UserDetailsManager userDetailsManager) {
        userDetailsManager.createUser(createUser("u1"));
        userDetailsManager.createUser(createUser("u2"));
    }

    private static UserDetails createUser(String name) {
        return User.withUsername(name)
                .password("{noop}" + name)
                .roles(ADMIN_ROLE)
                .build();
    }
}
