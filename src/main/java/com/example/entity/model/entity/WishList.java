package com.example.entity.model.entity;

import com.example.entity.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.REMOVE;

@Entity
@Table(name = "wishlist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String giftName;


    private LocalDate holidayDate;

    private String image; // file

    private String description;

    private String link;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Holiday> holidays;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}
