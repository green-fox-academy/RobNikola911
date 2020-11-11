package com.greenfox.p2pchat.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class CreateChannelDTO {

    private String name;
    private String description;
}
