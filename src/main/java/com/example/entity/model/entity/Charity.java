package com.example.entity.model.entity;

import com.example.entity.model.User;
import com.example.entity.model.entity.enums.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "charity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Charity {
    @Id
    @GeneratedValue(generator = "charity_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "charity_gen",sequenceName = "charity_seq",allocationSize = 1)
    private Long id;

    private String charityName;

    private String image;

    @Size(max = 5000)
    private String description;

    private LocalDate charityDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private SubCategories subCategories;

    // под вопросом
//    @Enumerated(EnumType.STRING)
//    private Condition condition;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}
