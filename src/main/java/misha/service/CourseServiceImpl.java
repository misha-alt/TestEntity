package misha.service;

import misha.dao.CourseDAO;
import misha.model.Course;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CourseServiceImpl implements CourseService {


   private CourseDAO courseDAO;
   private SessionFactory sessionFactory;

    @Autowired
    public CourseServiceImpl(CourseDAO courseDAO, SessionFactory sessionFactory) {
        this.courseDAO = courseDAO;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Course> allCourse() {

        return courseDAO.allCourse();
    }


    @Override
    public void delete(Course course) {

    }

    @Override
    public Course grtById(Long id) {

       return courseDAO.grtById(id);
    }


}
