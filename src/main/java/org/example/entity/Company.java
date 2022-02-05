package org.example.entity;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,name = "company_name",length = 30)
    private String name;
    private String location;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
    private List<Person> person;

    public Company() {
    }

    public Company(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
