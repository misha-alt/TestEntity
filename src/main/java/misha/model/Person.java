package misha.model;






import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import org.springframework.lang.Nullable;

import javax.persistence.*;


@Entity
@Table(name = "PERSON")
public class Person {
    @Id
//    @Null
//    @Column(name = "ID"/*, unique = true, nullable = false*/)

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name= "NAME")
    private String name;

    @Column(name = "AGE")
    private int age;

    @Column(name = "EMAIL")
    private String email;

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
}

