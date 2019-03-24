package io.vstream.apiserver.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // public urls
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/signup").permitAll()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/blog/**").permitAll()
                // following request must be authenticated
                .anyRequest().authenticated()
                .and()
                // login page
                .formLogin().loginPage("/login").failureUrl("/login?fail").permitAll()
                .and()
                // logout page
                .logout().clearAuthentication(true).invalidateHttpSession(true).deleteCookies().permitAll()
                .and()
                // csrf
                .csrf().csrfTokenRepository(new CookieCsrfTokenRepository());

    }
}
