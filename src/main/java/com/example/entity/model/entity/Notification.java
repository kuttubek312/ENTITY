package com.example.entity.model.entity;

import com.example.entity.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(generator = "notification_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "notification_gen", sequenceName = "notification_seq", allocationSize = 1)
    private Long id;
    private String text;
    private String image;
    private String header;

    @ManyToOne
    private User user;

    @ManyToOne
    @JsonIgnore
    private Charity charity;

    @ManyToOne
    @JsonIgnore
    private WishList wishList;

    @ManyToOne
    private Complaints complaints;

}
