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
public class BoardDTO {

    private String id;
    private String name;
    private String desc;
    private Boolean closed;
    private String idOrganization;
    private Boolean pinned;
}
