package org.example.dao;

import org.example.entity.Person;
import org.example.entity.SocialMedia;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class DaoSocialMedia implements DaoSocialMediaImpl{
    @Override
    public void saveSoMedia(SocialMedia socialMedia, List<Person>person) {
        try {
            Session session = HibernateUtil.getSession().openSession();
            session.beginTransaction();
            socialMedia.setPerson(person);
            session.save(socialMedia);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(int id) {
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
}
