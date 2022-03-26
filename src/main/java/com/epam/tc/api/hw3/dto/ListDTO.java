package com.epam.tc.api.hw3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListDTO {

    private String id;
    private String name;
    private Boolean closed;
    private String idBoard;
}
