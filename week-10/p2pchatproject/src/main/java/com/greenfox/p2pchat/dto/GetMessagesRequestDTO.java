package com.greenfox.p2pchat.dto;

import lombok.Getter;

@Getter
public class GetMessagesRequestDTO {

    private Integer channelId;
    private String channelSecret;
    private int count;

    public GetMessagesRequestDTO() {
    }

    public GetMessagesRequestDTO(Integer channelId, String channelSecret, int count) {
        this.channelId = channelId;
        this.channelSecret = channelSecret;
        this.count = count;
    }
}