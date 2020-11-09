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

    public UserResponseDTO(Long userId, String username) {
        this.userId = userId;
        this.username = username;
    }
}
