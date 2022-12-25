package com.example.entity.model.entity;

import com.example.entity.model.User;
import com.example.entity.model.entity.enums.ComplaintsType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.access.prepost.PreAuthorize;

/***
 * здесь кароче админге тийешелуу методтор либо башка сушность болуш керек
 * а что иммена здесь должен быть это мы еще посмотрим
 * и должны делать так что бы бул обьектке только админ мог взглинуть
 */
@Entity
// ADMIN
@Table(name = "complaints")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@PreAuthorize("hasAnyAuthority('ADMIN')")
public class Complaints {


    @Id
    @GeneratedValue(generator = "complaints_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "complaints_gen",sequenceName = "complaints_seq",allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ComplaintsType complaintsType;

    // private  String description;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "with_list_id")
    private WishList wishList;

    @ManyToOne
    @JoinColumn(name = "charity_id")
    @JsonIgnore
    private Charity charity;


}
