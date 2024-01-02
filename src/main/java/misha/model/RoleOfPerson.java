package misha.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PERSONROLES ")
public class RoleOfPerson {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ROLE_NAME")
    private String role_name;


   @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "roleOfPersonSet")
   private Set<Person> PersonSet;


    public RoleOfPerson() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Set<Person> getPersonSet() {
        return PersonSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        PersonSet = personSet;
    }
}
