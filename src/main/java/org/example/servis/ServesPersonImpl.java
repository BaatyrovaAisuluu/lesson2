package org.example.servis;

import org.example.dao.DaoPerson;
import org.example.dao.DaoPersonImpl;
import org.example.entity.*;

import java.util.List;

public class ServesPersonImpl implements ServesPerson {
    DaoPersonImpl daoPerson=new DaoPerson();
    @Override
    public void savePerson(List<Person> person, Company company, List<SocialMedia> socialMediaList, List<Car> cars, Garage garage) {
        daoPerson.savePerson(person,company,socialMediaList,cars,garage);
    }

    @Override
    public void findPersonById(int id) {
      daoPerson.findPersonById(id);
    }

    @Override
    public void deleteById(int id) {
      daoPerson.deleteById(id);
    }

    @Override
    public List<Person> findPersonByName(String name) {
        return daoPerson.findPersonByName(name);
    }
}
