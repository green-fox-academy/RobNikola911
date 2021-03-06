package com.greenfox.p2pchat.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateRequestDTO {
    private String username;
    private String avatarUrl;

    public UpdateRequestDTO(String username, String avatarUrl) {
        this.username = username;
        this.avatarUrl = avatarUrl;
    }
}
