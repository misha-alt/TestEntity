package misha.service;

import misha.dao.PersonDAO;
import misha.dao.PersonDAOImpl;

import misha.model.Person;
import misha.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private PersonDAO personDAO;

    @Autowired
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override

    public List<Person> allPerson() {
        return personDAO.allPerson();
    }

    @Override

    public void add(Person person) {
        personDAO.add(person);

    }

    @Override
    public void delete(Person person) {

    }

    @Override
    public void edit(Person person) {
        personDAO.delete(person);

    }

    @Override
    public Person grtById(int id) {

        return  personDAO.grtById(id);
    }

}
