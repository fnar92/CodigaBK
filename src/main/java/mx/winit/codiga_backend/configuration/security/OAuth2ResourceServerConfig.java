/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 *
 * @author Cliente
 */
@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                /*.antMatchers("/**").hasRole("ADMIN")
                .antMatchers("/**").hasRole("USER")*/
                .antMatchers("/usuario/create").permitAll()
                .antMatchers("/usuario/resetPassword").permitAll()
                .antMatchers("/usuario/activarCuenta").permitAll()
                .antMatchers("/oauth/token").permitAll()
                .antMatchers("/oauth/check_token**").permitAll()
                .antMatchers("/oauth/token/revokeById/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf()
                .disable()
                .sessionManagement().disable();
    }

}
