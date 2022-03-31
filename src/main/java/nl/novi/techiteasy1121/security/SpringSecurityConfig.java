package nl.novi.techiteasy1121.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
        auth
                .jdbcAuthentication()
                .passwordEncoder( new BCryptPasswordEncoder() )
                .dataSource( dataSource )
                .usersByUsernameQuery( "select username, password, enabled from users where username=?" )
                .authoritiesByUsernameQuery( "select username, role from users where username=?" );

    }
// JUST FOR TESTING ignore ALL security
    @Override
    public void configure( WebSecurity web ) {
        web
                .ignoring()
                .antMatchers( "/**" );
    }
    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers( "/private" ).hasAuthority( "ADMIN" )
                .antMatchers( "/public" ).hasAnyAuthority( "USER", "ADMIN" )
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS );
    }

}
