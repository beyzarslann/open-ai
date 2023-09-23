package com.archisacademy.openai.service.impl;

import com.archisacademy.openai.service.ChatService;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {
    @Override
    public String chat(String name) {
        return "Hello!" + name;
    }
}
