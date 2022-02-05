package org.example.servis;

import org.example.entity.Person;
import org.example.entity.SocialMedia;

import java.util.List;

public interface SocialMediaServes {
    public void saveSoMedia(SocialMedia socialMedia, List<Person> personList);
    public void delete(int id);
}
