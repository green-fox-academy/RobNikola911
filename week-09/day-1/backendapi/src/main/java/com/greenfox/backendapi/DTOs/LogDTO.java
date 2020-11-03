package com.greenfox.backendapi.DTOs;

import com.greenfox.backendapi.models.Log;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDTO {

    private List<Log> entries;
    private Integer entry_count;

}
