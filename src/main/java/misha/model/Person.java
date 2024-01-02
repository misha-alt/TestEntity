package misha.model;






import javax.persistence.*;
import java.util.Set;

/*import javax.persistence.*;*/


@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name= "NAME")
    private String name;

    @Column(name = "AGE")
    private int age;

    @Column(name = "EMAIL")
    private String email;


    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(name = "PERSON_COURSE", joinColumns = @JoinColumn(name = "PERSON_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    private Set<Course> courseSet;


    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(name = "PERSON_ROLES", joinColumns = @JoinColumn(name = "PERSON_ID"),
            inverseJoinColumns = @JoinColumn(name = "PERSONROLE_ID"))
    private Set<RoleOfPerson> roleOfPersonSet;


    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private PasswordClass password;

    public Person() {

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    public Set<RoleOfPerson> getRoleOfPersonSet() {
        return roleOfPersonSet;
    }

    public void setRoleOfPersonSet(Set<RoleOfPerson> roleOfPersonSet) {
        this.roleOfPersonSet = roleOfPersonSet;
    }

    public PasswordClass getPassword() {
        return password;
    }

    public void setPassword(PasswordClass password) {
        this.password = password;
    }
}

