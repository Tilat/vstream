package io.vstream.apiserver.conf;

import io.vstream.apiserver.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity()
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserAccountService userAccountService;

    @Autowired
    public SecurityConfig(final UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

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
                // following request must be authenticated
                .anyRequest().authenticated()
                //
                .and()
                // login page
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/do_login")
                .failureUrl("/login?fail=true")
                .permitAll()
                //
                .and()
                // logout page
                .logout()
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies()
                .permitAll()
                //
                .and()
                // csrf
                .csrf()
                .csrfTokenRepository(new CookieCsrfTokenRepository());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userAccountService);
    }
}
