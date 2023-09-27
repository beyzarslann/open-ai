package com.archisacademy.openai.service.impl;

import com.archisacademy.openai.dto.ChatRequest;
import com.archisacademy.openai.dto.ChatResponse;
import com.archisacademy.openai.service.ChatService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatServiceImpl implements ChatService {
    @Qualifier("openAiRestTemplate")
    private final RestTemplate restTemplate;

    public ChatServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String API_URL;

    @Override
    public String sendMessage(String message) {
        ChatRequest request = new ChatRequest(model, message);
        ChatResponse response = restTemplate.postForObject(API_URL, request, ChatResponse.class);
        return response.getChoices().get(0).getMessage().getContent();

    }
}
