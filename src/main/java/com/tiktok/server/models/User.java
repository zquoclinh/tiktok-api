package com.tiktok.server.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class User {
    //this is primary key
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName ="user_sequence",
            allocationSize = 1 //increment by 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private String fullName;
    private String nikeName;
    private String avatar;
    private String bio;
    private boolean tick;
    private Integer followingsCount;
    private Integer followersCount;
    private Integer likesCount;
    private String websiteUrl;
    private String facebookUrl;
    private String youtubeUrl;
    private String twitterUrl;
    private String instagramUrl;

    public User(String firstName, String lastName, String fullName, String nikeName, String avatar, String bio, boolean tick, Integer followingsCount, Integer followersCount, Integer likesCount, String websiteUrl, String facebookUrl, String youtubeUrl, String twitterUrl, String instagramUrl) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.nikeName = nikeName;
        this.avatar = avatar;
        this.bio = bio;
        this.tick = tick;
        this.followingsCount = followingsCount;
        this.followersCount = followersCount;
        this.likesCount = likesCount;
        this.websiteUrl = websiteUrl;
        this.facebookUrl = facebookUrl;
        this.youtubeUrl = youtubeUrl;
        this.twitterUrl = twitterUrl;
        this.instagramUrl = instagramUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", nikeName='" + nikeName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", bio='" + bio + '\'' +
                ", tick=" + tick +
                ", followingsCount=" + followingsCount +
                ", followersCount=" + followersCount +
                ", likesCount=" + likesCount +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", facebookUrl='" + facebookUrl + '\'' +
                ", youtubeUrl='" + youtubeUrl + '\'' +
                ", twitterUrl='" + twitterUrl + '\'' +
                ", instagramUrl='" + instagramUrl + '\'' +
                '}';
    }
}
