package org.example.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SocialMedias")
public class SocialMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(not= "Not probided")
    @Column(nullable = false)
    private String socialMedia;


    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "socialMedia")
    private List<Person> person;

    public SocialMedia() {
    }

    public SocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "SocialMedia{" +
                "id=" + id +
                ", socialMedia='" + socialMedia + '\'' +
                '}';
    }
}
