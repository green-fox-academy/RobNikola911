package com.greenfox.p2pchat.dto;

import com.greenfox.p2pchat.models.Channel;
import com.greenfox.p2pchat.models.Message;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class GetChannelResponseDTO {

    private Channel[] channels;

}