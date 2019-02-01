package com.ti.crowd_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * @author Ti
 * @date 2018/12/9
 */
@Configuration
@EnableWebSecurity
public class UrlSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin().and()
                .authorizeRequests()
                .antMatchers("/**/*.png").permitAll()
                .anyRequest().authenticated()
                .and().headers().frameOptions().disable()
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("tom")
                .password(new BCryptPasswordEncoder()
                        .encode("123")).roles("USER");

        /*auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select name,password,true from user where name=?")
                .authoritiesByUsernameQuery("select name,'ROLE_USER' from user where name=?")
                .passwordEncoder(new PasswordEncoder() {
                    @Override
                    public String encode(CharSequence charSequence) {
                        return charSequence.toString();
                    }

                    @Override
                    public boolean matches(CharSequence charSequence, String s) {
                        String pass = DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
                        if(pass.equals(s)){
                            return true;
                        }
                        return false;
                    }
                });*/
    }
}
