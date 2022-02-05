package org.example.dao;

import org.example.entity.Person;
import org.example.entity.SocialMedia;

import java.util.List;

public interface DaoSocialMediaImpl {
    public void saveSoMedia(SocialMedia socialMedia, List<Person> personList);
    public void delete(int id);
}
