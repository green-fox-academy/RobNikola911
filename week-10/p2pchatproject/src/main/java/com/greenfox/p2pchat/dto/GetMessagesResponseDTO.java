package com.greenfox.p2pchat.dto;

import com.greenfox.p2pchat.models.Message;
import lombok.Getter;

import java.util.List;

@Getter
public class GetMessagesResponseDTO {

    private List<Message> messages;

}