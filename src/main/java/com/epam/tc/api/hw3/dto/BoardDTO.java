package com.epam.tc.api.hw3.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardDTO {

    public String id;
    public String name;
    public String desc;
    public Object descData;
    public boolean closed;
}
