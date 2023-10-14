package misha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SwcurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/people").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin();

                /*.and()
                .formLogin()
                .and()
                .logout().logoutSuccessUrl("/new");*/

    }

  /*  @Bean
    public UserDetailsService users()  {
        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2a$12$XkA40MDkbhYw7BJ3ZBix1ehEA7FFNXfQSr4fNwotBuYF0NsDXsiKq")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2a$12$XkA40MDkbhYw7BJ3ZBix1ehEA7FFNXfQSr4fNwotBuYF0NsDXsiKq")
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }*/
@Bean
   public JdbcUserDetailsManager users (DataSource dataSource){
 /*   UserDetails user = User.builder()
            .username("USER")
            .password("{bcrypt}$2a$12$XkA40MDkbhYw7BJ3ZBix1ehEA7FFNXfQSr4fNwotBuYF0NsDXsiKq")
            .roles("USER")
            .build();
    UserDetails admin = User.builder()
            .username("ADMIN")
            .password("{bcrypt}$2a$12$XkA40MDkbhYw7BJ3ZBix1ehEA7FFNXfQSr4fNwotBuYF0NsDXsiKq")
            .roles("USER","ADMIN")
            .build();*/
    JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
  /*  jdbcUserDetailsManager.createUser(user);
    jdbcUserDetailsManager.createUser(admin);*/
    return jdbcUserDetailsManager;
}
}
