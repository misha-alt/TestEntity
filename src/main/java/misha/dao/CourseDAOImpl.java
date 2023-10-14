package misha.dao;

import misha.model.Course;
import misha.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
@Repository
public class CourseDAOImpl implements CourseDAO {

    private SessionFactory sessionFactory;
    private PersonDAO personDAO;
    @Autowired
    public CourseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Course> allCourse() {
        return sessionFactory.getCurrentSession().createQuery("from Course").list();
    }


    @Override
    public void delete(Course course) {

    }


    @Override
    public Course grtById(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Course p where p.id = :id");
        query.setParameter("id", id);
        List <Course> list = query.list();
        return list.get(0);
    }
}
