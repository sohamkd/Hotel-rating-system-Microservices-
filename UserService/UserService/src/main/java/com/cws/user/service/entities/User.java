package com.cws.user.service.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="micro-users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String uid;

    @Column(length = 25)
    private String name;

    private String email;

    private String about;

    @Transient
    private List<Rating> ratings=new ArrayList<>();
}
