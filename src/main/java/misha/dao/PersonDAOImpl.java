package misha.dao;
import misha.model.Course;
import misha.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
@Repository
public class PersonDAOImpl implements PersonDAO {


  private SessionFactory sessionFactory;
  private CourseDAO courseDAO;


    @Autowired
    public PersonDAOImpl(SessionFactory sessionFactory, CourseDAO courseDAO) {
        this.sessionFactory = sessionFactory;
        this.courseDAO = courseDAO;
    }


  /* private static int PEOPLE_COUNT;
    private List<Person>people;
    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Misha",23,"skdjosidhosdg"));
        people.add(new Person(++PEOPLE_COUNT,"Dima",31,"w;kojpwojpweg"));
        people.add(new Person(++PEOPLE_COUNT,"Ivan",28,"dlkfjokgofghhg"));

    }*/



    @Override
    public List<Person> allPerson() {


         return sessionFactory.getCurrentSession().createQuery("from Person").list();
    }

    @Override
    public void add(Person persons) {


     Session session = sessionFactory.getCurrentSession();
     session.persist(persons);


    }

    @Override
    public void delete(Person persons) {

    }

    @Override
    public void edit(Person persons ) {


        Session session = sessionFactory.getCurrentSession();

        session.update(persons);
    }

    @Override
    public Person grtById(Long id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Person.class, id);
    }


    @Override
    public void saveOrUpdate(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(person);

    }
}
