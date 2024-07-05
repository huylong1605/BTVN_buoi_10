package com.example.btvn_crud_restcontroller.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

     @Id
     @Column(name = "user_id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int userId;

     @Column(name = "user_name")
     private String userName;

     @Column(name = "user_age")
     private int userAge;


}
