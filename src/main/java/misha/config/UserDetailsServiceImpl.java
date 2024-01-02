package misha.config;

import misha.dao.PersonDAO;
import misha.model.Person;
import misha.model.RoleOfPerson;
import misha.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
@EnableWebSecurity
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonDAO personService;

    public UserDetailsServiceImpl(PersonDAO personService) {
        this.personService = personService;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Person person  = personService.getByName(name);

        if (person == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
                person.getName(),
                person.getPassword().getPassword(),
                getAuthorities(person)
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Person person) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for(RoleOfPerson roleOfPerson:person.getRoleOfPersonSet()){
            authorities.add(new SimpleGrantedAuthority(roleOfPerson.getRole_name()));
        }
        return authorities;
    }
    }

