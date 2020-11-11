package com.greenfox.p2pchat.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDTO {

    private Long userId;
    private String username;
    private String avatarurl;

    public UserResponseDTO(Long userId, String username, String avatarurl) {
        this.userId = userId;
        this.username = username;
        this.avatarurl = avatarurl;
    }
}
