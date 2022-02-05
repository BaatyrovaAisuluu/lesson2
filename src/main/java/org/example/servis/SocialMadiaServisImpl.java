package org.example.servis;

import org.example.dao.DaoPersonImpl;
import org.example.dao.DaoSocialMedia;
import org.example.dao.DaoSocialMediaImpl;
import org.example.entity.Person;
import org.example.entity.SocialMedia;

import java.util.List;

public class SocialMadiaServisImpl  implements SocialMediaServes{
    DaoSocialMediaImpl daoPerson= new DaoSocialMedia();
    @Override
    public void saveSoMedia(SocialMedia socialMedia, List<Person> personList) {
        daoPerson.saveSoMedia(socialMedia,personList);
    }

    @Override
    public void delete(int id) {
     daoPerson.delete(id);
    }
}
