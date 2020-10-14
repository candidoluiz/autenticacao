package br.com.hook.autenticacao.config;

import br.com.hook.autenticacao.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static br.com.hook.autenticacao.config.SecurytyConstant.SIGN_UP_URL;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailService customUserDetailService;
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable()
//            .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/user/salvar").permitAll()
//                .antMatchers(HttpMethod.GET,"/user").permitAll()
//                .anyRequest()
//                .authenticated()
//            .and()
//                .httpBasic();
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable() .authorizeRequests()
               .antMatchers(HttpMethod.GET, SIGN_UP_URL).permitAll()
                .antMatchers(HttpMethod.POST, "/user/salvar").permitAll()
                .antMatchers(HttpMethod.GET,"/user").permitAll()
                .and()
                .addFilter(new JWTAutenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager(), customUserDetailService));

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(customUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }
}


