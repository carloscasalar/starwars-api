package com.cca.starwars.config;

import com.cca.starwars.auth.SameUserAsPassAuthProvider;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private SameUserAsPassAuthProvider sameUserAsPassAuthProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("user1").password("userA").roles("ADMIN");
        auth.authenticationProvider(sameUserAsPassAuthProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/planets**").permitAll()
                .antMatchers("/films**").hasRole("ADMIN")
                .antMatchers("/persons**").authenticated();
    }
}
