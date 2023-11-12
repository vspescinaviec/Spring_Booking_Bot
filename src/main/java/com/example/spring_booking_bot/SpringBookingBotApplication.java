package com.example.spring_booking_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
public class SpringBookingBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBookingBotApplication.class, args);
	}
}

