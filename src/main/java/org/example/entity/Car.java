package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String mark;
    private String producedCountry;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_Id")
    private Person person;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "car")
    private Garage garage;

    public Car(String mark, String producedCountry) {
        this.mark = mark;
        this.producedCountry = producedCountry;
    }

    public Car() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getProducedCountry() {
        return producedCountry;
    }

    public void setProducedCountry(String producedCountry) {
        this.producedCountry = producedCountry;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", producedCountry='" + producedCountry + '\'' +
                '}';
    }
}
