package com.example.spring_booking_bot;

import com.example.spring_booking_bot.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramBot;

import java.util.Collections;

@Component
public class Bot extends TelegramLongPollingBot {

    @Autowired
    UserRepo userRepo;


    @Override
    public String getBotToken(){
        return "6789701525:AAHLCzMHDRlZvt6sI9q0e3TsGNe27rMj2Hg";
    }



    @Override
    public String getBotUsername() {
        return "doctorbogdan_bot";
    }

    @Override
    public void onUpdateReceived(Update update) {
        KeyboardRow k = new KeyboardRow();
        if(userRepo.findUserModelByTgId(update.getMessage().getFrom().getId().toString())==null){
            k.add(new KeyboardButton("Log in"));
        }
        k.add(new KeyboardButton("Записаться к врачу"));
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText("Выберите действие");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Collections.singletonList(k));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        try{
            execute(sendMessage);
        }catch (TelegramApiException telegramApiException){
            telegramApiException.printStackTrace();
        }
    }
}
