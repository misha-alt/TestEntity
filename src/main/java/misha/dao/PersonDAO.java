package misha.dao;

import misha.model.Person;
import misha.model.Person;
import org.springframework.ui.Model;


import java.util.List;

public interface PersonDAO {
    List<Person> allPerson();
    void add(Person person);
    void delete(Person person);
    void edit(Person person);
    Person grtById(int iD);

}
