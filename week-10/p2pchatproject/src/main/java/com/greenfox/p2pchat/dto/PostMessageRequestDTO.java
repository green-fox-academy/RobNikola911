package com.greenfox.p2pchat.dto;

import lombok.Getter;

@Getter
public class PostMessageRequestDTO {

    private Integer channelId;
    private String channelSecret;
    private String content;

    public PostMessageRequestDTO() {
    }

    public PostMessageRequestDTO(Integer channelId, String channelSecret, String content) {
        this.channelId = channelId;
        this.channelSecret = channelSecret;
        this.content = content;
    }
}