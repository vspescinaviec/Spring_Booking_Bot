package com.example.spring_booking_bot.models;

import javax.persistence.*;

@Entity
@Table(name = "telegram_user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "username")
    String username;

    @Column(name="telegram_id")
    String tgId;

    @Column(name="u_name")
    String name;
}
