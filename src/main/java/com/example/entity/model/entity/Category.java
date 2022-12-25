package com.example.entity.model.entity;

import com.example.entity.model.User;
import com.example.entity.model.entity.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    Long id;
    private Animals animals;
    private Clothes clothes;
    private Electronic electronic;
    private HouseAndGarden houseAndGarden;
    private Transport transport;
    private Shoes shoes;
    private School school;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
