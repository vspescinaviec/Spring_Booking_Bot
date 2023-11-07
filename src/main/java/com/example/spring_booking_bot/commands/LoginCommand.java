package com.example.spring_booking_bot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.Collections;

public class LoginCommand implements WorkerCommand{

    @Override
    public SendMessage start(Update update) {
        if(!update.getMessage().getText().equals("Log in")){
            return null;
        }
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        if(update.getMessage().getText().equals("Log in")){
            KeyboardRow keyboardRow= new KeyboardRow();
            keyboardRow.add(new KeyboardButton("Оставить свое имя"));
            keyboardRow.add(new KeyboardButton("Остаться анонимом"));
            sendMessage.setText("Выберите действие");

            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setKeyboard(Collections.singletonList(keyboardRow));
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
        }
        return sendMessage;
    }

    @Override
    public SendMessage sendDefaultMessage(Update update) {
        return null;
    }
}
