package com.wuubzi.chatbot.Services;

import com.wuubzi.chatbot.DTO.Request.AskDTO;
import com.wuubzi.chatbot.DTO.Response.AskResponseDTO;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    @Autowired
    public ChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public AskResponseDTO ask(AskDTO askDTO){
        String response = chatClient.prompt()
                .messages(new SystemMessage("""
                        Eres un chatbot conciso y claro.
                        - Responde en frases cortas.
                        - Evita párrafos largos.
                        - Mantén un tono sencillo y amable.
                        - Da solo la información necesaria.
                        """))
                .user(askDTO.getMessage())
                .call()
                .content();
        AskResponseDTO responseDTO = new AskResponseDTO();
        responseDTO.setMessage(response);
        return responseDTO;
    }
}
