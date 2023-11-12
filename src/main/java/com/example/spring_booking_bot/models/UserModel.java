package com.example.spring_booking_bot.models;

import lombok.Data;

import javax.persistence.*;

@Table(name = "telegram_user")
@Entity
@Data
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
