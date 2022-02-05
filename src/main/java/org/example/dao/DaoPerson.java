package org.example.dao;

import org.example.entity.*;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class DaoPerson implements DaoPersonImpl{
    @Override
    public void savePerson(List<Person>person, Company company,
                           List<SocialMedia> socialMediaList, List<Car> cars, Garage garage) {
        try {
            Session session = HibernateUtil.getSession().openSession();
            session.beginTransaction();
            person.stream().forEach(person1 -> person1.setCompany(company));
            person.stream().forEach(person1 -> person1.setSocialMedia(socialMediaList));
            person.stream().forEach(person1 -> person1.setCars(cars));
            cars.stream().forEach(car -> car.setPerson((Person) person));
            cars.stream().forEach(car -> car.setGarage(garage));
            for (int i = 0; i < person.size(); i++) {
                session.save(person.get(i));
            }
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void findPersonById(int id) {
        try(Session session=HibernateUtil.getSession().openSession()) {
            session.beginTransaction();
            Person person = session.get(Person.class, id);
            System.out.println(person);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            Session session = HibernateUtil.getSession().openSession();
            session.beginTransaction();
            Person person = session.get(Person.class, id);
            session.remove(person);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Person> findPersonByName(String name) {
        List<Person>list=new ArrayList<>();
        try {
            Session session = HibernateUtil.getSession().openSession();
            session.beginTransaction();
            list = session.createQuery("from Person").list();
            list.stream().filter(person -> person.getName().equals(name)).forEach(System.out::println);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;

    }
}
