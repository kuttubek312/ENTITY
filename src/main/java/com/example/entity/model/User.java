package com.example.entity.model;

import com.example.entity.model.entity.*;
import com.example.entity.model.entity.ClothingSize;
import com.example.entity.model.entity.enums.Country;
import com.example.entity.model.entity.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

/**
 * по приглошение зарипбека поляга user дин соц сеттерин кошуш керек
 * но как его добавить это вопрос времнии
 */

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(generator = "user_gen", strategy =
            GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_gen",
            sequenceName = "user_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    private String email;

    @Column(name = "phone_number")
    private Long number;

    private boolean image;

    @Column(name = "country")
    private Country country;

    private String password;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Size(max = 50000)
    private String hobbies;

    @Size(max = 5000)
    @Column(name = "important_to_know")
    private String importantToKnow;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, mappedBy = "user")
    private List<WishList> wishList;

    @OneToMany(cascade = ALL,mappedBy = "user")
    @JsonIgnore
    private List<Holiday> holiday;

    @OneToMany(cascade = ALL,mappedBy = "user")
    private List<Complaints> complaints;

    @OneToMany(cascade = ALL,mappedBy = "user")
    private List<Charity> charity;

    @OneToMany(cascade = ALL,mappedBy = "userId")
    private List<Booking> bookings;

    @OneToMany(cascade = ALL,mappedBy = "user")
    private List<ClothingSize> clothingSizes;

    @OneToMany(cascade = ALL,mappedBy = "user")
    private List<ShoeSize> shoeSizes;

    @OneToMany(cascade = ALL,mappedBy = "user")
    private List<Category> categories;

    @ManyToMany(fetch = FetchType.EAGER,
    cascade = ALL)
    @JoinColumn(name = "friends")
    @JsonIgnore
    private List<User> friends = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER,
    cascade = ALL)
    @JsonIgnore
    private List<User> requestToFriends = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> grantedAuthorities = new LinkedList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        return grantedAuthorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
