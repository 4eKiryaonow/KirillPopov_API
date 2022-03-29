package com.epam.tc.api.hw3.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListDTO {

    private String id;
    private String name;
    private Boolean closed;
    private String idBoard;
}
