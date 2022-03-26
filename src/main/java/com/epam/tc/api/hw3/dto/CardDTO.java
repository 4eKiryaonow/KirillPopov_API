package com.epam.tc.api.hw3.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardDTO {

    private String id;
    private String name;
    private String idList;
    private String desc;
}
