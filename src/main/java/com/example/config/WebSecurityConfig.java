package com.example.config;

import com.example.domain.User;
import com.example.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Shaurav on 3/17/2017.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserMongoRepository userMongoRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .and()
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .permitAll();

    }
    @Override
    @Bean
    protected UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userMongoRepository.findByUsername(username);
                if (user != null){
                    return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), true, true, true, true,
                            AuthorityUtils.createAuthorityList("USER"));
                }
                else {
                    throw new UsernameNotFoundException("could not find the user '"
                            + username + "'");}
            }
        };
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("resources/static/**");
    }






    protected void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }
}
