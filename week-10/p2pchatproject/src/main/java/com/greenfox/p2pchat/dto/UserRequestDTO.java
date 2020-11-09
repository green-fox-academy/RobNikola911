package com.greenfox.p2pchat.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequestDTO {

    private String login;
    private String password;

    public UserRequestDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
