package misha.service;

import misha.model.Course;
import misha.model.Person;
import org.springframework.ui.Model;


import java.util.List;

public interface PersonService {
    List<Person> allPerson();
    void add(Person person);
    void delete(Person person);
    void edit(Person person);
    Person grtById(Long iD);
}
