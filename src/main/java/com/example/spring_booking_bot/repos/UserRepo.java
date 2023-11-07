package com.example.spring_booking_bot.repos;

import com.example.spring_booking_bot.models.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserModel, Long> {
    UserModel findUserModelByTgId(String id);
}
