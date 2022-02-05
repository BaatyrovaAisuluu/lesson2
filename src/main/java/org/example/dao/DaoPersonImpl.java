package org.example.dao;

import org.example.entity.*;

import java.util.List;

public interface DaoPersonImpl {

    public void savePerson(List<Person>person, Company company, List<SocialMedia> socialMediaList, List<Car>cars, Garage garage);
    public void findPersonById(int id);
    public void deleteById(int id);
    public List<Person> findPersonByName(String name);
}
