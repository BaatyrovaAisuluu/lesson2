package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "garages")
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String GarageName;
    private boolean isEmpty;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Car_id")
    private Car car;

    public Garage(String garageName, boolean isEmpty) {
        GarageName = garageName;
        this.isEmpty = isEmpty;
    }

    public Garage() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGarageName() {
        return GarageName;
    }

    public void setGarageName(String garageName) {
        GarageName = garageName;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", GarageName='" + GarageName + '\'' +
                ", isEmpty=" + isEmpty +
                '}';
    }
}
