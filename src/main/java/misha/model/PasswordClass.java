package misha.model;

import javax.persistence.*;

@Entity
@Table(name = "PASSWORD")
public class PasswordClass {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

   @Column(name = "PASSWORD")
    private String password;

   @OneToOne
   @JoinColumn(name = "person_id")
   private Person person;

    public PasswordClass() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
